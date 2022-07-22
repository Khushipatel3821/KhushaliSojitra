package com.application.x;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //remove App Title bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main5);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity5.this, MainActivity6.class);
                startActivity(i);
            }
        }, 3000);
    }
        @Override
        public void onBackPressed() {

            finishAffinity();
    }
}