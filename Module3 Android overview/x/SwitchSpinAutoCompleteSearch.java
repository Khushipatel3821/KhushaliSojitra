package com.application.x;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SwitchSpinAutoCompleteSearch extends AppCompatActivity {

    Switch switch1;
    AutoCompleteTextView auto1;
    ListView listView;
    List<String> list;
    SearchView searchView;
    Spinner spinner;
    String city[]={"Rajkot","Baroda","Surat", "Vadodara", "Jamnagar", "Gandhinagar", "Bhavnagar"};
   /* MediaPlayer mediaPlayer;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_spin_auto_complete_search);

        switch1 = findViewById(R.id.switch1);
        auto1=findViewById(R.id.auto1);
        listView=findViewById(R.id.list);
        list=new ArrayList<>();
        searchView=findViewById(R.id.search);
        spinner=findViewById(R.id.spin1);

        ArrayAdapter arrayAdapter2=new ArrayAdapter(SwitchSpinAutoCompleteSearch.this, android.R.layout.simple_spinner_dropdown_item,city);
        spinner.setAdapter(arrayAdapter2);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(SwitchSpinAutoCompleteSearch.this, "your selected city is "+city[i], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        list.add("Rajkot");
        list.add("Surat");
        list.add("Ahemedabad");
        list.add("Vadodara");
        list.add("Jamnagar");
        list.add("Bhavnagar");
        list.add("Himatnagar");


        ArrayAdapter arrayAdapter=new ArrayAdapter(SwitchSpinAutoCompleteSearch.this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {

                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });



        ArrayAdapter arrayAdapter1=new ArrayAdapter(SwitchSpinAutoCompleteSearch.this, android.R.layout.select_dialog_item,city);
        auto1.setThreshold(1);
        auto1.setAdapter(arrayAdapter1);

        /* mediaPlayer=MediaPlayer.create(SwitchSpinAutoCompleteSearch.this,R.raw.);*/

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(switch1.isChecked())
                {
                    Toast.makeText(SwitchSpinAutoCompleteSearch.this, "Switch is on", Toast.LENGTH_SHORT).show();
                    /*mediaPlayer.start();*/
                }
                else
                {
                    Toast.makeText(SwitchSpinAutoCompleteSearch.this, "Switch is Off", Toast.LENGTH_SHORT).show();
                   /* mediaPlayer.stop();*/

                }

            }
        });

    }
}