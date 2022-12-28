package com.application.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class FrameByFrame extends AppCompatActivity {

    private ImageView imageView;
    private AnimationDrawable animationDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_by_frame);

        imageView=findViewById(R.id.imageView);
        animationDrawable=(AnimationDrawable)(imageView.getBackground());

        if(animationDrawable.isRunning()){
            animationDrawable.stop();
        }
        else{
            animationDrawable.start();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(FrameByFrame.this, LayoutAnimation.class);
                startActivity(i);
            }
        }, 3000);
    }
}