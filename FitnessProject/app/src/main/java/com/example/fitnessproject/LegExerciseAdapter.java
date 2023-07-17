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

public class LegExerciseAdapter extends ArrayAdapter<LegExercise> {

private Context ct;
private ArrayList<LegExercise>arr;


    public LegExerciseAdapter(Context context, int resource,List<LegExercise> objects) {
        super(context, resource, objects);
        this.ct=context;
        this.arr=new ArrayList<>(objects);


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LegExercise legExercise=getItem(position);
if(convertView==null){
    LayoutInflater i = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    convertView=i.inflate(R.layout.exercise,null);


}

if (arr.size()>0){
LegExercise le =arr.get(position);
    ImageView imgLeg=convertView.findViewById(R.id.imgLeg);

    TextView txvExeName=convertView.findViewById(R.id.name);
    TextView txvTime=convertView.findViewById(R.id.exetime);
    imgLeg.setImageResource(le.image);
    txvTime.setText(le.time);
    txvExeName.setText(le.name);

}
return convertView;
    }
}
