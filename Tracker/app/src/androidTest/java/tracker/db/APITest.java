package tracker.db;


import android.app.Application;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

public class APITest {
    public static final String TAG = "APITest";
    private API dbapi;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private ChildEventListener mChildEventListener;
    private DatabaseReference patients;
    private Patient patient;
    private String patientId;


    @Before
    public void setUp() throws Exception {
        Application application = ApplicationProvider.getApplicationContext();
        FirebaseApp.initializeApp(application);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        dbapi = new API(mFirebaseDatabase);
        Log.d(TAG, "Attempting Login");
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    Log.d(TAG, "Login Successful");
                    patients = dbapi.getPatient();
                    mChildEventListener = new ChildEventListener() {
                        @Override
                        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                            Log.d(TAG, "Child Added: " + dataSnapshot.getKey());
                            patientId = dataSnapshot.getKey();
                            patient = dataSnapshot.getValue(Patient.class);
                            Log.d(TAG, patient.toString());
                        }

                        @Override
                        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                            Log.d(TAG, "Child Removed: " + dataSnapshot.getKey());
                        }

                        @Override
                        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    };
                    patients.addChildEventListener(mChildEventListener);
                }
                else {
                    Log.d(TAG, "Login Failed");
                }
            }
        };
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
        mFirebaseAuth.signInWithEmailAndPassword("tester@firebase.com", "F!r3B@$3T3$t");

    }

    @After
    public void tearDown() throws Exception {
        mFirebaseAuth.signOut();
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }


    @Test
    public void addToDb() {
        dbapi.addToDb("Patient", "John", "Doe", "Test_Roomid");
        assert(patient.getFirst().equals("John"));
        assert(patient.getLast().equals("Doe"));
        assert(patient.getLocationId().equals("Test_Roomid"));

    }

//    @Test
//    public void updateDb() {
//    }
//

    @Test
    public void removeFromDb() {
        dbapi.addToDb("Patient", "John", "Doe", "Test_Roomid");
        assert(!patientId.equals(null));
        if (patientId != null) {
            dbapi.removeFromDb("Patient", patientId);
        }
    }


}