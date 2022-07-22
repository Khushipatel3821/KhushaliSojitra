package com.application.x;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {


    EditText edt1,edt2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

       // this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        edt1 = findViewById(R.id.ed1);
        edt2 = findViewById(R.id.ed2);
        btn = findViewById(R.id.btnm);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt1.getText().toString();
                String pass = edt2.getText().toString();

                if (name.length() == 0 && pass.length() == 0) {
                    edt1.setError("Please enter your name");
                    edt2.setError("please enter your Password");
                } else if (name.length() == 0) {
                    edt1.setError("Please enter your name");
                } else if (pass.length() == 0) {
                    edt2.setError("please enter your Password");
                } else {
                    if (name.equals("Khushali") && pass.equals("3821")) {
                        Toast.makeText(MainActivity6.this, "Success", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(MainActivity6.this, UiControl.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(MainActivity6.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
    }
        @Override
        public void onBackPressed() {

            //finishAffinity();
            AlertDialog.Builder alert =new AlertDialog.Builder(MainActivity6.this);
            alert.setTitle("Are you sue you want to exit?");
            alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    finishAffinity();
                }
            });

            alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.cancel();
                }
            });

            alert.show();
    }
}