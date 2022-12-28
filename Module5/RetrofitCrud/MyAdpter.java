package com.application.retrofitcrud;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyAdpter extends RecyclerView.Adapter<MyAdpter.MyView>
{
    Context context;
    List<Model> list;
    ApiInterface apiInterface;

    public MyAdpter(Context context, List<Model> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //LayoutInflater inflater=LayoutInflater.from(context);
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdpter.MyView holder,@SuppressLint("RecyclerView") int position)
    {
        holder.t1.setText(list.get(position).name);
        holder.t2.setText(list.get(position).price);
        holder.t3.setText(list.get(position).des);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
                alert.setTitle("Are you sure to select that??");
                alert.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent i=new Intent(context, UpdateActivity.class);

                        i.putExtra("id",list.get(position).getId());
                        i.putExtra("name",list.get(position).getName());
                        i.putExtra("price",list.get(position).getPrice());
                        i.putExtra("desc",list.get(position).getDes());

                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        v.getContext().startActivity(i);
                    }
                });

                alert.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                      apiInterface = ApiClient.getapiclient().create(ApiInterface.class);
                        Call<Model> call = apiInterface.deletedata((list.get(position).getId()));
                        call.enqueue(new Callback<Model>() {
                            @Override
                            public void onResponse(Call<Model> call, Response<Model> response) {


                                Toast.makeText(v.getContext(), "deleted", Toast.LENGTH_SHORT).show();

                                Intent i =new Intent();
                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            }

                            @Override
                            public void onFailure(Call<Model> call, Throwable t) {

                            }
                        });
                        v.getContext().startActivity(new Intent(v.getContext(),MainActivity2.class));
                    }
                });
                alert.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

   public class MyView extends RecyclerView.ViewHolder
    {
        TextView t1, t2, t3;
        public MyView(@NonNull View itemView) {
            super(itemView);

            t1= itemView.findViewById(R.id.txt1);
            t2= itemView.findViewById(R.id.txt2);
            t3= itemView.findViewById(R.id.txt3);

        }
    }
}
