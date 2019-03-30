package com.example.tracker;

import com.google.firebase.FirebaseApp;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_main);
    }

    public void signIn(View v) {
        Intent LoginIntent = new Intent(this, LoginActivity.class);
        startActivity(LoginIntent);
    }

    public void signUp(View v) {
        Intent SingUpIntent = new Intent(this, SignUpActivity.class);
        startActivity(SingUpIntent);
    }
}
