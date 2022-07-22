package com.application.x;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tx, tx1, tx2;
    ImageView img, img1, img2;
    Button b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx=findViewById(R.id.t1);
        tx1=findViewById(R.id.t2);
        tx2=findViewById(R.id.t3);
        img=findViewById(R.id.i1);
        img1=findViewById(R.id.i2);
        img2=findViewById(R.id.i3);
        b6=findViewById(R.id.b6);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Explicit
                startActivity( new Intent(MainActivity.this , MainActivity2.class));

            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Explicit
                startActivity( new Intent(MainActivity.this , MainActivity3.class));

            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Explicit
                startActivity( new Intent(MainActivity.this , MainActivity4.class));

            }
        });

        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Implicit
                String url = "https://www.iplt20.com/teams/gujarat-titans/squad";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Implicit
                String url = "https://www.iplt20.com/teams/mumbai-indians/squad";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        tx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Implicit
                String url = "https://www.iplt20.com/teams/royal-challengers-bangalore/squad";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, SwitchSpinAutoCompleteSearch.class);
                startActivity(i);
            }
        });
    }
}