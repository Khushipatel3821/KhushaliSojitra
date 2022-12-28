package com.application.jsoncrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2, edt3;
    Button btn1;
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        btn1 = findViewById(R.id.btn1);
        txt1 = findViewById(R.id.txt1);


        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String name = edt1.getText().toString();
                String price = edt2.getText().toString();
                String des = edt3.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, MyUrl.INSERT, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this, "No internet", Toast.LENGTH_SHORT).show();
                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError
                    {
                        HashMap map = new HashMap();
                        map.put("p_name",name);
                        map.put("p_price",price);
                        map.put("p_des",des);

                        return map;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                requestQueue.add(stringRequest);
            }
        });

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(in);
            }
        });
    }
}