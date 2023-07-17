package com.example.fitnessproject;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class BellyExerciseAdapter extends ArrayAdapter<BellyExercise>{

    private Context ct;
    private ArrayList<BellyExercise>arr;

    public BellyExerciseAdapter(Context context, int resource, List<BellyExercise> objects) {
        super(context, resource, objects);
        this.ct=context;
        this.arr=new ArrayList<>(objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        BellyExercise bellyExercise=getItem(position);
        if(convertView==null){
            LayoutInflater i = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=i.inflate(R.layout.belly_exercise,null);


        }

        if (arr.size()>0){
            BellyExercise ar =arr.get(position);
            ImageView imgArm=convertView.findViewById(R.id.imgBelly);

            TextView txvExeName=convertView.findViewById(R.id.Bellyname);
            TextView txvTime=convertView.findViewById(R.id.Bellyexetime);
            imgArm.setImageResource(ar.image);
            txvTime.setText(ar.time);
            txvExeName.setText(ar.name);

        }
        return convertView;
    }
}

