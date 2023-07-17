package com.example.fitnessproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class diet extends AppCompatActivity {
    private Spinner goalSpinner;
    private Button generatePlanButton;
    private String selectedGoal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        goalSpinner = findViewById(R.id.goal_spinner);
        generatePlanButton = findViewById(R.id.generate_plan_button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.goals, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        goalSpinner.setAdapter(adapter);

        goalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedGoal = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        generatePlanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatePlan(selectedGoal);
            }
        });
    }

    private void generatePlan(String goal) {
        String tt1 = "";
        String tt2 = "";
        String tt3 = "";

        switch (goal) {
            case "Lose Weight":
                tt1 =   "3 large scrambled eggs\n" +
                        "1 slice whole wheat toast\n"+
                        "Greek Yogurt";
                tt2 = "4 ounces grilled chicken breast\n" +
                        "1/4 cup black beans\n"+
                        "1 slice rye bread";
                tt3 = "6 ounces grilled salmon\n" +
                        "1/2 cup cooked brown rice\n"+
                        "1 cup steamed mixed vegetables";
                break;
            case "Gain Weight":
                tt1 =   "3 large scrambled eggs\n" +
                        "1 slice whole wheat toast\n"+
                        "Greek Yogurt";
                tt2 = "4 ounces grilled chicken breast\n" +
                        "1/4 cup black beans\n"+
                        "1 slice rye bread";
                tt3 = "6 ounces grilled salmon\n" +
                        "1/2 cup cooked brown rice\n"+
                        "1 cup steamed mixed vegetables";
                break;
            case "Keep Fit":
                tt1 =   "3 large scrambled eggs\n" +
                        "1 slice whole wheat toast\n"+
                        "Greek Yogurt";
                tt2 = "4 ounces grilled chicken breast\n" +
                        "1/4 cup black beans\n"+
                        "1 slice rye bread";
                tt3 = "6 ounces grilled salmon\n" +
                        "1/2 cup cooked brown rice\n"+
                        "1 cup steamed mixed vegetables";
                break;
        }

        Intent intent = new Intent(diet.this, planActivity.class);
        intent.putExtra("1", tt1);
        intent.putExtra("2", tt2);
        intent.putExtra("3", tt3);
        startActivity(intent);
    }

}
