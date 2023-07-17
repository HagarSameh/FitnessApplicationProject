package com.example.fitnessproject;

import static com.example.fitnessproject.R.color.teal_800;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {
    private CardView d1,d2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("POWERFitness");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(teal_800)));
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNVHome);
        bottomNavigationView.setSelectedItemId(R.id.homenaav);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.homenaav:
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.dietnav:
                    startActivity(new Intent(getApplicationContext(),diet.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.reportnav:
                    startActivity(new Intent(getApplicationContext(),ReportPage.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    finish();
                    return true;

                case R.id.profilenav:
                    startActivity(new Intent(getApplicationContext(),settingpage.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    finish();
                    return true;
            }
            return false;
        });
    }
    public void onArmClicked(View view){
        Intent intent=new Intent(this, Arm.class);
        startActivity(intent);

    }

    public void onBellyClicked(View view){
        Intent intent=new Intent(this,Belly.class);
        startActivity(intent);
    }
    public void onLegClicked(View view){
        Intent intent=new Intent(this,Leg.class);
        startActivity(intent);
    }

//    @Override
//    public void onClick(View v){
//
//        Intent i;
//        switch (v.getId()){
//
//            case R.id.d1:
//                i=new Intent(this,d1.class);
//                startActivity(i);
//                break;
//
//            case R.id.d2:
//                i=new Intent(this,d2.class);
//                startActivity(i);
//                break;
//
//
//
//
//
//        }
//
//    }

}