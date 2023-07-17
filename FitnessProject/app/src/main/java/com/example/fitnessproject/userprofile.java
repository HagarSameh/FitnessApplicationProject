package com.example.fitnessproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class userprofile extends AppCompatActivity {
    EditText h , b , w;
    static String height, weight, birth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        h=findViewById(R.id.editTextTextPersonName);
        w=findViewById(R.id.editTextTextPersonName2);
        b=findViewById(R.id.editTextDate);

        height = com.example.fitnessproject.height.height;
        weight = com.example.fitnessproject.height.weight;

        h.setText(height);
        w.setText(weight);

        birth=b.getText().toString();
    }
}