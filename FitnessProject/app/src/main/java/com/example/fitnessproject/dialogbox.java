package com.example.fitnessproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class dialogbox extends AppCompatActivity {
    Button dec ,inc ,set;
    TextView num;
    String duration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogbox);

        ActionBar actionBar=getSupportActionBar();
        assert actionBar != null;
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        dec=findViewById(R.id.dec);
        inc=findViewById(R.id.inc);
        set=findViewById(R.id.button_positive);
        num=findViewById(R.id.number);

        dec.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int number=Integer.parseInt(num.getText().toString());
                if(number>=11) {
                    number -= 1;
                    num.setText(Integer.toString(number));
                }
            }
        });
        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number=Integer.parseInt(num.getText().toString());
                if(number <=29) {
                    number += 1;
                    num.setText(Integer.toString(number));
                }
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duration=num.getText().toString();

            }
        });
    }
}