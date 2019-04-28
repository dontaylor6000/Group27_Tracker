package com.example.tracker;

import com.firebase.ui.auth.AuthUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import tracker.backgroundsvc.InternetConnectionManager;
import tracker.db.API;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int RC_SIGN_IN = 1;
    private static final String TAG = "MainActivity";
    private API dbapi;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private FirebaseDatabase mFirebaseDatabase;


    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_tracker:
                    mTextMessage.setText(R.string.title_tracker);
                    return true;

                case R.id.navigation_person:
                    mTextMessage.setText(R.string.title_person);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
               case R.id.navigation_map:
                    mTextMessage.setText(R.string.title_map);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerReceiver(connectionChangeReceiver, new IntentFilter(
                InternetConnectionManager.CONNECTIVITY_ACTION));
        bindService(new Intent(this, InternetConnectionManager.class),
                mICMConnection, Context.BIND_AUTO_CREATE);

        FirebaseApp.initializeApp(this);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    dbapi = new API(mFirebaseDatabase);
                            setContentView(R.layout.activity_main);


                   mTextMessage = (TextView) findViewById(R.id.message);
                  BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
                  navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
                    //setContentView(R.id.home);
                    //Toast.makeText(MainActivity.this, "Signed in! Welcome to Tracker", Toast.LENGTH_SHORT).show();

                }
                else{
                    List<AuthUI.IdpConfig> providers = Arrays.asList(
                            new AuthUI.IdpConfig.EmailBuilder().build(),
                            new AuthUI.IdpConfig.GoogleBuilder().build());
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(providers)
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    private void setOnlineMode(boolean isOnline) {
//        mapView.setModifiable(isOnline);
//        locateButton.setEnabled(isOnline);
//        addLocationButton.setEnabled(isOnline);

    }

    private ServiceConnection mICMConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            InternetConnectionManager mManager = ((InternetConnectionManager.LocalBinder) service)
                    .getService();
            setOnlineMode(mManager.isOnline());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

    };

    /**
     * Receives notifications about connectivity changes
     */
    private BroadcastReceiver connectionChangeReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            setOnlineMode((intent.getFlags() & InternetConnectionManager.ONLINE_FLAG)== InternetConnectionManager.ONLINE_FLAG);
        }

    };
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN){
            if (resultCode == RESULT_OK){
                Toast.makeText(this, "Logged in Successfully!", Toast.LENGTH_SHORT).show();
            }
            else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Log-in cancelled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
        Log.d(TAG, "Request Code" + requestCode);
    }

    @Override
    protected void onResume(){
        super.onResume();
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause(){
        super.onPause();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

    }

}
