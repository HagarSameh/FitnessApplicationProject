package com.example.fitnessproject;


import static com.example.fitnessproject.R.color.teal_800;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;



public class CrossSideLunge extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 600000;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;

    private CountDownTimer mCoutDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = 30000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crosslunge);
        getSupportActionBar().setTitle("POWERFitness");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(teal_800)));
        mTextViewCountDown = findViewById(R.id.countdown);
        mButtonStartPause = findViewById(R.id.button_start);

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mTimerRunning) {
                    pauseTimer();
                } else startTimer();
            }

        });

    }

    private void startTimer(){
        mCoutDownTimer=new CountDownTimer(mTimeLeftInMillis,1000) {
            @Override
            public void onTick(long mTimeLeftInMillis) {

//        updateCountDownText();
                long seconds=mTimeLeftInMillis/1000;
                String timeString=String.format(Locale.getDefault(),"%02d:%02d",seconds/60,seconds%60);
                mTextViewCountDown.setText(timeString);
            }

            @Override
            public void onFinish() {
                mTimerRunning=false;
                mButtonStartPause.setText("start");

            }
        }.start();
        mTimerRunning=true;
        mButtonStartPause.setText("Pause");


    }

    private void pauseTimer(){
        mCoutDownTimer.cancel();
        mTimerRunning=false;
        mButtonStartPause.setText("start");

    }






}
