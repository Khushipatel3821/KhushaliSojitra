package com.application.retrofitcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText edt1,edt2,edt3;
    Button btn1, btn2;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        edt3=findViewById(R.id.edt3);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edt1.getText().toString();
                String price= edt2.getText().toString();
                String des = edt3.getText().toString();

                apiInterface = ApiClient.getapiclient().create(ApiInterface.class);
                Call<Model> call = apiInterface.insertdata(name, price, des);
                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response)
                    {
                        Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t)
                    {
                        Toast.makeText(MainActivity.this, ""+t, Toast.LENGTH_SHORT).show();
                    }
                });
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }
}