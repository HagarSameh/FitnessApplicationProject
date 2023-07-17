package com.example.fitnessproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class settingpage extends AppCompatActivity {
    ListView l;
    String[] title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingpage);
        l=findViewById(R.id.list);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        // Start Activity A
                        Intent intentA = new Intent(settingpage.this, userprofile.class);
                        startActivity(intentA);
                        break;
                    case 1:
                        // Start Activity B
                        Intent intentB = new Intent(settingpage.this, remindeerrr.class);
                        startActivity(intentB);
                        break;
                    case 4:
                        AlertDialog.Builder builder = new AlertDialog.Builder(settingpage.this);
                        builder.setTitle("Reset Progress");
                        builder.setMessage("set all the progress to zero");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Handle OK button click
                                // Perform any actions needed
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();

                        break;
                    case 3:
                        // Start Activity C
                        Intent intentC = new Intent(settingpage.this, privacypolicy.class);
                        startActivity(intentC);
                        break;
                    case 2:
                        // Start Activity C
                        Intent intentD = new Intent(settingpage.this, dialogbox.class);
                        startActivity(intentD);
                        break;
                    default:
                        break;

                }
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            }
        });



    }
}