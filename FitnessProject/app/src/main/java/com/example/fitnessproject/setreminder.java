package com.example.fitnessproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class setreminder extends AppCompatActivity {
    NumberPicker hour ,minute , am;
    Button finish;
    String[] time={"AM" , "PM"};
    String time_;
    String h , m;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setreminder);


        hour=findViewById(R.id.hourPicker);
        minute=findViewById(R.id.minutePicker);
        am=findViewById(R.id.AMPicker);
        finish=findViewById(R.id.finish_rem_btn);

        hour.setMinValue(1);
        hour.setMaxValue(12);
        minute.setMinValue(0);
        minute.setMaxValue(59);
        am.setMinValue(0);
        am.setMaxValue(1);
        am.setDisplayedValues(time);

        hour.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                h=Integer.toString(newVal);
            }
        });
        minute.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                m=Integer.toString(i1);
            }
        });
        am.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                time_+=" "+i1;
            }
        });
        finish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                LocalTime Time = LocalTime.of(10, 30);
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
//                String formattedTime = Time.format(formatter);
//                System.out.println(formattedTime);
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });
    }



}
