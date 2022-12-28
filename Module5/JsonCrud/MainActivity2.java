package com.application.jsoncrud;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;
    List<Model>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.list);
        list = new ArrayList<>();

        registerForContextMenu(listView);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, MyUrl.VIEW, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try
                {

                    JSONArray jsonArray = new JSONArray(response);
                    for (int i=0; i< jsonArray.length(); i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        int id = jsonObject.getInt("id");
                        String name = jsonObject.getString("p_name");
                        String price = jsonObject.getString("p_price");
                        String des = jsonObject.getString("p_des");

                        Model m = new Model();
                        m.setId(id);
                        m.setName(name);
                        m.setPrice(price);
                        m.setDes(des);
                        list.add(m);
                    }
                    MyAdpter myAdpter = new MyAdpter(getApplicationContext(),list);
                    listView.setAdapter(myAdpter);

                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(MainActivity2.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity2.this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem m1 = menu.add(0,1,0,"Update");
        MenuItem m2 = menu.add(0,2,0,"Delete");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo acm = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id = acm.position;
        Model m = list.get(id);

        switch(item.getItemId())
        {
            case 1:
                break;

            case 2:
               AlertDialog.Builder alert =new  AlertDialog.Builder(MainActivity2.this);
               alert.setTitle("Are you sure for delete the data ??");
               alert.setPositiveButton("Yes", new DialogInterface.OnClickListener()
               {
                   @Override
                   public void onClick(DialogInterface dialog, int which)
                   {
                       StringRequest stringRequest = new StringRequest(Request.Method.POST, MyUrl.DELETE,
                               new Response.Listener<String>()
                               {
                                   @Override
                                   public void onResponse(String response)
                                   {
                                       Toast.makeText(MainActivity2.this, "Deleted", Toast.LENGTH_SHORT).show();
                                       Intent i = new Intent(MainActivity2.this, MainActivity2.class);
                                       startActivity(i);
                                   }
                               }, new Response.ErrorListener()
                       {
                           @Override
                           public void onErrorResponse(VolleyError error)
                           {
                               Toast.makeText(MainActivity2.this, "No Internet", Toast.LENGTH_SHORT).show();

                           }
                       })
                       {
                           @Override
                           protected Map<String, String> getParams() throws AuthFailureError {
                               HashMap map = new HashMap();
                               map.put("id",String.valueOf(m.getId()));
                               return map;
                           }
                       };
                       RequestQueue requestQueue = Volley.newRequestQueue(MainActivity2.this);
                       requestQueue.add(stringRequest);
                   }
               });
               alert.setNegativeButton("No", new DialogInterface.OnClickListener()
               {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       dialogInterface.cancel();
                   }
               });
               alert.show();

                break;
        }
        return super.onContextItemSelected(item);
    }
}