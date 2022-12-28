package com.application.firebasecrud;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;


public class MyAdpter extends FirebaseRecyclerAdapter<Model, MyAdpter.myviewholder>
{
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */

    public MyAdpter(FirebaseRecyclerOptions<Model> options)
    {
        super(options);
    }

    @SuppressLint("RecyclerView")
    @Override
   protected void onBindViewHolder(@NonNull myviewholder holder, int i, @NonNull Model model) {
        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());
        holder.pass.setText(model.getPassword());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(), "update", Toast.LENGTH_SHORT).show();
                final DialogPlus dialogPlus= DialogPlus.newDialog(holder.edit.getContext())
                        .setContentHolder(new ViewHolder(R.layout.edit))
                        .setExpanded(true,1100)
                        .create();

                View myview=dialogPlus.getHolderView();

                final EditText name=myview.findViewById(R.id.e1);
                final EditText pass=myview.findViewById(R.id.e2);
                final EditText email=myview.findViewById(R.id.e3);
                Button submit=myview.findViewById(R.id.btn1);



                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Map<String,Object> map=new HashMap<>();

                        map.put("name",name.getText().toString());
                        map.put("email",email.getText().toString());
                        map.put("password",pass.getText().toString());


                        FirebaseDatabase.getInstance().getReference().child("tops1")
                                .child(getRef(i).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialogPlus.dismiss();

                                        Toast.makeText(email.getContext(), "Updated", Toast.LENGTH_SHORT).show();
                                        // holder.edit.getContext().startActivity(new Intent(holder.edit.getContext(),MainActivity.class));
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialogPlus.dismiss();
                                    }
                                });



                    }
                });

                name.setText(model.getName());
                pass.setText(model.getPassword());
                email.setText(model.getEmail());

                dialogPlus.show();


            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert=new AlertDialog.Builder(holder.delete.getContext());
                alert.setTitle("DLEETE?");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        FirebaseDatabase.getInstance().getReference().child("tops1")
                                .child(getRef(i).getKey()).removeValue();

                        //holder.delete.getContext().startActivity(new Intent(holder.delete.getContext(),MainActivity.class));

                        notifyItemRangeChanged(i,0);


                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();

                    }
                });
                alert.show();


            }
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);
        return new myviewholder(view);
    }
    class myviewholder extends RecyclerView.ViewHolder
    {

        TextView name,pass,email;
        ImageView edit,delete;


        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            // img=(CircleImageView) itemView.findViewById(R.id.img1);
            name=itemView.findViewById(R.id.txt1);
            email=itemView.findViewById(R.id.txt2);
            pass=itemView.findViewById(R.id.txt3);
            edit=itemView.findViewById(R.id.edit);
            delete=itemView.findViewById(R.id.delete);
        }
    }
}
