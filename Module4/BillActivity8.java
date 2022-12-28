package com.application.x;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BillActivity8 extends AppCompatActivity  {


    TextView txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill8);

        txt3 = findViewById(R.id.text3);
        Intent i =getIntent();
        String bill=i.getStringExtra("bill");
        txt3.setText(bill);

    }
}