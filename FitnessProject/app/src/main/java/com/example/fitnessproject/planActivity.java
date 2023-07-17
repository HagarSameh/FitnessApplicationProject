package com.example.fitnessproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class planActivity extends AppCompatActivity {
    private TextView breakfast;
    private TextView lunch;
    private TextView dinner;
    private TextView t1;
    private TextView t2;
    private TextView t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);


        breakfast = findViewById(R.id.breakfast);
        t1 = findViewById(R.id.t1);
        lunch = findViewById(R.id.lunch);
        t2 = findViewById(R.id.t2);
        dinner = findViewById(R.id.dinner);
        t3 = findViewById(R.id.t3);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String tt1 = extras.getString("1");
            String tt2 = extras.getString("2");
            String tt3 = extras.getString("3");



            breakfast.setText("Breakfast");
            t1.setText(tt1);
            lunch.setText("Lunch");
            t2.setText(tt2);
            dinner.setText("dinner");
            t3.setText(tt3);

        }
    }
}

