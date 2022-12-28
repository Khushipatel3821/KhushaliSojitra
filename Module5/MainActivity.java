package com.application.firebasecrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    FloatingActionButton fab;
    MyAdpter myAdpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        fab = findViewById(R.id.fab);

        RecyclerView.LayoutManager rl = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rl);

        FirebaseRecyclerOptions<Model>options=new FirebaseRecyclerOptions.Builder<Model>()
                .setQuery( FirebaseDatabase.getInstance().getReference().child("tops1"),Model.class)
                .build();

        myAdpter =new MyAdpter(options);
        recyclerView.setAdapter(myAdpter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, AddUser.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        myAdpter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myAdpter.stopListening();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        myAdpter.startListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        myAdpter.startListening();
    }

    @Override
    protected void onPause() {
        super.onPause();
        myAdpter.stopListening();
    }
}