package com.example.fitnessproject;

import static com.example.fitnessproject.R.color.teal_800;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fitnessproject.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class Belly extends AppCompatActivity {
    ListView lsvBelly;
    ActivityMainBinding binding;
    ArrayList<BellyExercise> dataArrayList=new ArrayList<>();
    BellyExercise BellyExercise;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        setContentView(R.layout.activity_belly);
        getSupportActionBar().setTitle("POWERFitness");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(teal_800)));

        lsvBelly=findViewById(R.id.lsvBelly);
        ArrayList<BellyExercise> arr=new ArrayList<>();
        arr.add(new BellyExercise(R.drawable.kneehug,"00:15","Knee hugs"));
        arr.add(new BellyExercise(R.drawable.tpress,"00:30","T press"));
        arr.add(new BellyExercise(R.drawable.reversecrunches,"00:20","Reverse"));
        arr.add(new BellyExercise(R.drawable.sprinter,"00:10","Sprinter"));
        arr.add(new BellyExercise(R.drawable.ankle,"00:30","Ankle push"));
        BellyExerciseAdapter adapter=new BellyExerciseAdapter(this,0,arr);

        lsvBelly.setAdapter(adapter);
        lsvBelly.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){

                    startActivity(new Intent(getApplicationContext(),hugknee.class));

                }
                if(i==1){

                    startActivity(new Intent(getApplicationContext(),tpress.class));

                }

                if(i==2){

                    startActivity(new Intent(getApplicationContext(),reversecrunshes.class));

                }
                if(i==3){

                    startActivity(new Intent(getApplicationContext(),sprinter.class));

                }
                if(i==4){

                    startActivity(new Intent(getApplicationContext(),ankle.class));

                }
            }
        });

    }
}