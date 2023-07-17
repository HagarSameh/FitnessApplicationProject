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





public class ArmExerciseAdapter extends ArrayAdapter<ArmExercise>{

    private Context ct;
    private ArrayList<ArmExercise>arr;

    public ArmExerciseAdapter(Context context, int resource,List<ArmExercise> objects) {
        super(context, resource, objects);
        this.ct=context;
        this.arr=new ArrayList<>(objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ArmExercise armExercise=getItem(position);
        if(convertView==null){
            LayoutInflater i = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=i.inflate(R.layout.arm_exercise,null);


        }

        if (arr.size()>0){
            ArmExercise ar =arr.get(position);
            ImageView imgArm=convertView.findViewById(R.id.imgArm);

            TextView txvExeName=convertView.findViewById(R.id.armname);
            TextView txvTime=convertView.findViewById(R.id.armexetime);
            imgArm.setImageResource(ar.image);
            txvTime.setText(ar.time);
            txvExeName.setText(ar.name);

        }
        return convertView;
    }
}

