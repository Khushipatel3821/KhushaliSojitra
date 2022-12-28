package com.application.firebasecrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddUser extends AppCompatActivity {

    EditText edt1,edt2,edt3;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        edt3=findViewById(R.id.edt3);
        btn1=findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n=edt1.getText().toString();
                String e=edt2.getText().toString();
                String p=edt3.getText().toString();

                HashMap map = new HashMap();
                map.put("name",n);
                map.put("email",e);
                map.put("password",p);

                FirebaseDatabase.getInstance().getReference()
                        .child("tops1")
                        .push()
                        .setValue(map)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(AddUser.this, "Inserted", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(AddUser.this,MainActivity.class));
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e)
                            {
                                Toast.makeText(AddUser.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        });



            }
        });

    }
}