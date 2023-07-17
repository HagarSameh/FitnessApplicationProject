package com.example.fitnessproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;

public class remindeerrr extends AppCompatActivity {
    SwitchCompat s ,s2;
    String reminder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remindeerrr);
        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        s = (SwitchCompat) findViewById(R.id.switch1);
        s2= (SwitchCompat) findViewById(R.id.switch2);
        if(s.isChecked()){
            reminder="20:00";
        }else if (s2.isChecked()){
            reminder="18:45";
        }
    }
}