package com.example.fitnessproject;

import static com.example.fitnessproject.R.color.teal_800;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class DetailedLegView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_leg_view);
        getSupportActionBar().setTitle("POWERFitness");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(teal_800)));

    }
}