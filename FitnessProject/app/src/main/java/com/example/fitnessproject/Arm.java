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

public class Arm extends AppCompatActivity {
    ListView lsvArm;
    ActivityMainBinding binding;
    ArrayList<ArmExercise> dataArrayList=new ArrayList<>();
    LegExercise ArmExercise;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        setContentView(R.layout.activity_arm);
        getSupportActionBar().setTitle("POWERFitness");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(teal_800)));

        lsvArm=findViewById(R.id.lsvArm);
        ArrayList<ArmExercise> arr=new ArrayList<>();
        arr.add(new ArmExercise(R.drawable.updownplank,"00:30","Up-down plank"));
        arr.add(new ArmExercise(R.drawable.shoulderrolll,"00:30","shoulder roll"));
        arr.add(new ArmExercise(R.drawable.bentovertwist,"00:10","Over twist"));
        arr.add(new ArmExercise(R.drawable.crosssignlungee,"00:25","Cross lunge"));



        ArmExerciseAdapter adapter=new ArmExerciseAdapter(this,0,arr);

        lsvArm.setAdapter(adapter);
        lsvArm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){


                    startActivity(new Intent(getApplicationContext(),updown.class));

                }
                if(i==1){

                    startActivity(new Intent(getApplicationContext(),sholder.class));

                }

                if(i==2){

                    startActivity(new Intent(getApplicationContext(),overtwist.class));

                }
                if(i==3){

                    startActivity(new Intent(getApplicationContext(),sidelunge.class));

                }

            }
        });

    }
}