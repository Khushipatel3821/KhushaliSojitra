package com.application.animation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReciever extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED))
        {
            Toast.makeText(context, "Battery Action Changed", Toast.LENGTH_SHORT).show();
        }
    }
}
