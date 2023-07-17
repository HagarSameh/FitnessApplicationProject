package com.example.fitnessproject;

import static com.example.fitnessproject.R.color.teal_800;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class TipsActivity extends AppCompatActivity {
ListView lsvTips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        getSupportActionBar().setTitle("POWERFitness");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(teal_800)));

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.tips);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.diet:
                    startActivity(new Intent(getApplicationContext(),diet.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.tips:
                    startActivity(new Intent(getApplicationContext(),TipsActivity.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    finish();
                    return true;
            }
            return false;
        });

        lsvTips=findViewById(R.id.lsvTips);
        ArrayList<Tipss>arr=new ArrayList<>();
            arr.add(new Tipss(R.drawable.fruit,"Fruit","Consume fruit with varying color each day "));
            arr.add(new Tipss(R.drawable.water,"Water","Drink 8 cups of water daily "));
            arr.add(new Tipss(R.drawable.junkfood,"Junk Food","Avoid junk " + "food "));
            arr.add(new Tipss(R.drawable.cleanhand,"Cleanliness","keep your hands clean "));
            arr.add(new Tipss(R.drawable.exercise,"Exercise","Exercise for half hour daily "));
            arr.add(new Tipss(R.drawable.physiotherapy,"Physiotherapy","Continue visit phsiotherapy"));

        TipssAdapter adapter=new TipssAdapter(this,0,arr);

        lsvTips.setAdapter(adapter);
        lsvTips.setOnScrollListener(new AbsListView.OnScrollListener(){
            int scrollThreshold=10;
            int scrollY=0;
            @Override
            public void onScrollStateChanged(AbsListView view,int scrollState){}
            @Override
            public void onScroll(AbsListView view,int firstVisibleItem, int VisibleItemCount,int totalItemCount){
                View topView=view.getChildAt(0);
                if (topView==null) {
                    return;
                }
                int topY=topView.getTop();
                if(Math.abs(topY-scrollY)>scrollThreshold) {
                    if(topY<scrollY) {
                        bottomNavigationView.setVisibility(View.GONE);
                    } else {
                        bottomNavigationView.setVisibility(View.VISIBLE);
                    }
                    scrollY=topY;
                }
            }
        });
    }
}