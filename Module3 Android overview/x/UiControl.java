package com.application.x;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class UiControl extends AppCompatActivity implements View.OnClickListener, RatingBar.OnRatingBarChangeListener, SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {

    EditText edt1;
    CheckBox chk1, chk2, chk3;
    Button b1, b2, b3, b4;
    RadioButton rb1, rb2;
    ProgressBar pb1;
    RatingBar rt1;
    ImageView image2;
    SeekBar seek1, seek2, seek3;
    WebView web1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_control);

        edt1 = findViewById(R.id.edt1);
        image2 = findViewById(R.id.image2);
        pb1 = findViewById(R.id.pb1);
        seek1 = findViewById(R.id.seek1);
        seek2 = findViewById(R.id.seek2);
        seek3 = findViewById(R.id.seek3);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        chk1 = findViewById(R.id.chk1);
        chk2 = findViewById(R.id.chk2);
        chk3 = findViewById(R.id.chk3);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rt1 = findViewById(R.id.rt1);
        web1 = findViewById(R.id.web1);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        rt1.setOnRatingBarChangeListener(this);
        seek1.setOnSeekBarChangeListener(this);
        seek2.setOnSeekBarChangeListener(this);
        seek3.setOnSeekBarChangeListener(this);
        rb1.setOnCheckedChangeListener(this);
        rb2.setOnCheckedChangeListener(this);
        web1.loadUrl("https://www.baps.org/home.aspx");


    }

    @Override
    public void onClick(View v) {
        if (v == b1)
        {
            StringBuilder builder = new StringBuilder();
            builder.append("\n Selected Items \n");
            int price = 0;

            if (chk1.isChecked()) {
                price += 10000;
                builder.append("\n  Mobile @ rs.10000 \n ");
            }
            if (chk2.isChecked()) {
                price += 470;
                builder.append("\n  Charger @ rs.470 \n ");
            }
            if (chk3.isChecked()) {
                price += 1200;
                builder.append("\n Cable @ rs.1200 \n ");
            }
            builder.append("\n  Total :" + price);
            Toast.makeText(UiControl.this, "" + builder.toString(), Toast.LENGTH_SHORT).show();

            Intent i = new Intent(UiControl.this, BillActivity8.class);
            i.putExtra("bill", builder.toString());
            startActivity(i);
        }
        if (v == b2)
        {
            pb1.incrementProgressBy(2);
            setProgress(100 * pb1.getProgress());
        }
        if (v == b3)
        {
            pb1.incrementProgressBy(-2);
            setProgress(100 * pb1.getProgress());
        }
        if (v == b4)
        {
            Intent i = new Intent(UiControl.this,MainActivity.class);
            startActivity(i);
        }
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

        String r = String.valueOf(ratingBar.getRating());
        Toast.makeText(UiControl.this, "" + r, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        int r = seek1.getProgress();
        int g = seek2.getProgress();
        int b = seek3.getProgress();
        image2.setBackgroundColor(Color.rgb(r, g, b));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (rb1.isChecked()) {
            Toast.makeText(UiControl.this, "Male", Toast.LENGTH_SHORT).show();
        }
        if (rb2.isChecked()) {
            Toast.makeText(UiControl.this, "Female", Toast.LENGTH_SHORT).show();
        }
    }
}