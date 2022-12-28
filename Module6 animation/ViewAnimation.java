package com.application.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class ViewAnimation extends AppCompatActivity
{
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);

        imageView=findViewById(R.id.img);

        Animation animation= AnimationUtils.loadAnimation(ViewAnimation.this,R.anim.rotate);
        imageView.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(ViewAnimation.this, FrameByFrame.class);
                startActivity(i);
            }
        }, 3000);

    }
}