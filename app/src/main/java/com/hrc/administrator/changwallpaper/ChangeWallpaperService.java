package com.hrc.administrator.changwallpaper;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.io.IOException;
import java.io.InputStream;

public class ChangeWallpaperService extends Service {
    private static int index=0;
    private int[] resIds=new int[]{R.raw.wp1,R.raw.wp2,R.raw.wp3,R.raw.wp4,R.raw.wp5};

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        if(index==5)
            index=0;
        InputStream inputStream=getResources().openRawResource(resIds[index++]);
        try{
            setWallpaper(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onStart(intent, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
