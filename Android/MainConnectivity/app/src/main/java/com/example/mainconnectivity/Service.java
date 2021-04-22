package com.example.mainconnectivity;

import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class Service extends android.app.Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        MainActivity ma = new MainActivity();

        return Service.START_NOT_STICKY;
    }

}
