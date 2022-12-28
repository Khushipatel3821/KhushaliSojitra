package com.application.retrofitcrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity
{
    RecyclerView recyclerView;
    List<Model> list;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView= findViewById(R.id.recycler);
        list = new ArrayList<>();

        RecyclerView.LayoutManager rl = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rl);

        apiInterface = ApiClient.getapiclient().create(ApiInterface.class);
        Call<List<Model>> call = apiInterface.viewdata();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response)
            {
                list = response.body();

                MyAdpter myAdpter = new MyAdpter(getApplicationContext(),list);
                recyclerView.setAdapter(myAdpter);
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }
}