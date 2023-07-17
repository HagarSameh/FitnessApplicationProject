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

public class Leg extends AppCompatActivity {
    ListView lsvLeg;
    ActivityMainBinding binding;
    ArrayList<LegExercise> dataArrayList=new ArrayList<>();
    LegExercise legExercise;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        setContentView(R.layout.activity_leg);
        getSupportActionBar().setTitle("POWERFitness");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(teal_800)));

        lsvLeg=findViewById(R.id.lsvLeg);
        ArrayList<LegExercise> arr=new ArrayList<>();
        arr.add(new LegExercise(R.drawable.highstepping,"00:30","High Stepping"));
        arr.add(new LegExercise(R.drawable.lungpic,"00:20","Lung Kicks"));
        arr.add(new LegExercise(R.drawable.squat,"00:15","Kick Squats "));

        arr.add(new LegExercise(R.drawable.legliftpic,"00:35","Back Leg Lift "));
        arr.add(new LegExercise(R.drawable.singleggif,"00:20","Leg Bridge "));





        LegExerciseAdapter adapter=new LegExerciseAdapter(this,0,arr);

        lsvLeg.setAdapter(adapter);
     lsvLeg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             if(i==0){
           
                 startActivity(new Intent(getApplicationContext(),highknee.class));

             }
             if(i==1){

                 startActivity(new Intent(getApplicationContext(),lungkick.class));

             }

             if(i==2){

                 startActivity(new Intent(getApplicationContext(),squats.class));

             }
             if(i==3){

                 startActivity(new Intent(getApplicationContext(),backleg.class));

             }
             if(i==4){

                 startActivity(new Intent(getApplicationContext(),singleleg.class));

             }
         }
     });

    }
}