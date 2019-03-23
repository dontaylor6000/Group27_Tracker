package com.example.tracker;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ResetSentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_sent);
    }


    public void goHome(View v) {
        Intent HomeIntent = new Intent(this, MainActivity.class);
        startActivity(HomeIntent);
    }
}
