package com.hrc.administrator.changwallpaper;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button start,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button)findViewById(R.id.changeWallpaper);
        stop=(Button)findViewById(R.id.stopChange);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        stop.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent=PendingIntent.getService(this,0,new Intent(this,ChangeWallpaperService.class),0);
        switch (v.getId()){
            case R.id.changeWallpaper:
                alarmManager.setRepeating(AlarmManager.RTC,0,5*1000,pendingIntent);
                start.setEnabled(false);
                stop.setEnabled(true);
                break;
            case R.id.stopChange:
                alarmManager.cancel(pendingIntent);
                start.setEnabled(true);
                stop.setEnabled(false);
                break;
        }
    }
}
