package com.example.fitnessproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Button;

public class firstScreen extends AppCompatActivity {
    Button loseWeight , keepFit ,getStronger, next_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        loseWeight= findViewById(R.id.btn1);
        String btn1Text = "LOSE WEIGHT \n Get lean fast and healthy";
        SpannableString spannableString = new SpannableString(btn1Text);
        RelativeSizeSpan sizeSpan = new RelativeSizeSpan(1.5f);
        spannableString.setSpan(sizeSpan, 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        loseWeight.setText(spannableString);
        loseWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loseWeight.setBackground(getResources().getDrawable(R.drawable.rounded_button3));

            }
        });

        keepFit=findViewById(R.id.btn2);
        String btn2Text = "GET STRONGER \n Tone up and get better shape";
        SpannableString spannableString2 = new SpannableString(btn2Text);
        RelativeSizeSpan sizeSpan2 = new RelativeSizeSpan(1.5f);
        spannableString2.setSpan(sizeSpan2, 0, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        keepFit.setText(spannableString2);
        keepFit.setOnClickListener(view -> keepFit.setBackground(getResources().getDrawable(R.drawable.rounded_button3)));

        getStronger=findViewById(R.id.btn4);
        String btn3Text = "KEEP FIT \n Stay fit and improve health";
        SpannableString spannableString3 = new SpannableString(btn3Text);
        RelativeSizeSpan sizeSpan3 = new RelativeSizeSpan(1.5f);
        spannableString3.setSpan(sizeSpan3, 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getStronger.setText(spannableString3);
        getStronger.setOnClickListener(view -> getStronger.setBackground(getResources().getDrawable(R.drawable.rounded_button3)));

        next_btn = findViewById(R.id.next_welcome_btn);
        next_btn.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),height.class);
            startActivity(i);
        });
    }
}