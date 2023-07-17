package com.example.fitnessproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class setgoal extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner num_of_days,first_Day;
    String Number_of_days , First_Day;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setgoal);
        num_of_days =findViewById(R.id.days);
        first_Day=findViewById(R.id.first_day);
        ArrayAdapter<CharSequence> adapter1= ArrayAdapter.createFromResource(this,R.array.num_days ,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        num_of_days.setAdapter(adapter1);
        num_of_days.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter2= ArrayAdapter.createFromResource(this,R.array.first_day ,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        first_Day.setAdapter(adapter2);
        first_Day.setOnItemSelectedListener(this);
        next=findViewById(R.id.next_btn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),setreminder.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item=adapterView.getItemAtPosition(i).toString();
        if(adapterView==num_of_days){
            System.out.println("Number of days"+item);
            Number_of_days=item;
        }else if(adapterView==first_Day){
            System.out.println("First"+item);
            First_Day=item;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}