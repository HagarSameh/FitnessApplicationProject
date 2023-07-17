package com.example.fitnessproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TipssAdapter extends ArrayAdapter<Tipss> {

private Context ct;
private ArrayList<Tipss>arr;


    public TipssAdapter(@NonNull Context context, int resource, @NonNull List<Tipss> objects) {
        super(context, resource, objects);
        this.ct=context;
        this.arr=new ArrayList<>(objects);


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
if(convertView==null){
    LayoutInflater i = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    convertView=i.inflate(R.layout.healthytips,null);


}

if (arr.size()>0){
Tipss t=arr.get(position);
    ImageView imgTips=convertView.findViewById(R.id.imgTips);

    TextView txvSubname=convertView.findViewById(R.id.sub_name);
    TextView txvName=convertView.findViewById(R.id.name);
    imgTips.setImageResource(t.image);
    txvSubname.setText(t.subname);
    txvName.setText(t.name);


}
return convertView;
    }
}
