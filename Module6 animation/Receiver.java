package com.application.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;

public class Receiver extends AppCompatActivity {

    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

         /*  btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
*/
        IntentFilter i =new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        MyReciever m =new MyReciever();
        registerReceiver(m,i);

       /* btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });*/

    }
}