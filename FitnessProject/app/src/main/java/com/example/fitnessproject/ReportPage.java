package com.example.fitnessproject;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class ReportPage extends AppCompatActivity {
    private TextView textViewBMI, textViewBMICategory, textViewWeightValue, textWorkoutsSummary, textCaloriesSummary, textMinutesSummary, textViewHeightValue;
    private BarChart barChartCalories,barChartExercises;
    private Button buttonUpdateBMI, buttonUpdateWeight, buttonUpdateHeight;
    private List<BarEntry> caloriesEntries = new ArrayList<>();
    private List<BarEntry> exerciseEntries = new ArrayList<>();
    private int totalWorkouts = 0, totalCaloriesBurned = 0;
    private float totalMinutes = 0, bmi = 0, heightValue, weightValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page);
        getSupportActionBar().setTitle("POWERFitness");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_800)));

        textViewBMI = findViewById(R.id.textViewBMI);
        textViewBMICategory = findViewById(R.id.textViewBMICategory);
        textViewWeightValue = findViewById(R.id.textViewWeightValue);
        buttonUpdateBMI = findViewById(R.id.buttonUpdateBMI);
        buttonUpdateWeight = findViewById(R.id.buttonUpdateWeight);
        textWorkoutsSummary = findViewById(R.id.textWorkoutsSummary);
        textCaloriesSummary = findViewById(R.id.textCaloriesSummary);
        textMinutesSummary = findViewById(R.id.textMinutesSummary);
        barChartCalories = findViewById(R.id.barChartCalories);
        barChartExercises = findViewById(R.id.barChartExercises);
        textViewHeightValue = findViewById(R.id.textViewHeightValue);
        buttonUpdateHeight = findViewById(R.id.buttonUpdateHeight);

        buttonUpdateBMI.setOnClickListener(v -> showBMIDialog());
        buttonUpdateWeight.setOnClickListener(v -> showWeightDialog());
        buttonUpdateHeight.setOnClickListener(v -> showHeightDialog());

        weightValue = Float.parseFloat(height.weight);
        textViewWeightValue.setText(String.valueOf(weightValue));

        heightValue = Float.parseFloat(height.height);
        textViewHeightValue.setText(String.valueOf(heightValue));

        recalculateBMI();

        // Summary text
        textWorkoutsSummary.setText(String.valueOf(totalWorkouts));
        textCaloriesSummary.setText(String.valueOf(totalCaloriesBurned));
        textMinutesSummary.setText(String.valueOf(totalMinutes));

        addToCalories();
        addToExercises();

        // Display charts
        displayCaloriesChart();
        displayExercisesChart();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNVHome);
        bottomNavigationView.setSelectedItemId(R.id.reportnav);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.homenaav:
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.dietnav:
                    startActivity(new Intent(getApplicationContext(), diet.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.profilenav:
                    startActivity(new Intent(getApplicationContext(), TipsActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
            }
            return false;
        });
    }

    private void showHeightDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Height Dialog");
        builder.setMessage("Enter your height");

        final EditText editText = new EditText(this);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        builder.setView(editText);

        builder.setPositiveButton("Save", (dialog, which) -> {
            String heightStr = editText.getText().toString().trim();
            if (!heightStr.isEmpty()) {
                float heightValue = Float.parseFloat(heightStr);
                textViewHeightValue.setText(String.valueOf(heightValue));
                saveHeightValue(heightValue);

                recalculateBMI();
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private float getHeightValue() {
        return heightValue;
    }

    private void saveHeightValue(float newHeightValue) {
        textViewHeightValue.setText(String.valueOf(newHeightValue));
        userprofile.height = String.valueOf(newHeightValue);
        recalculateBMI();
    }

    private float calculateBMI(float weight, float height) {
        float heightInMeter = height / 100;
        return weight / (heightInMeter * heightInMeter);
    }

    private void recalculateBMI(){
        bmi = calculateBMI(getWeightValue(), getHeightValue());
        textViewBMI.setText(String.valueOf(bmi));
        String bmiCategory = getBMICategory(bmi);
        textViewBMICategory.setText(bmiCategory);
    }

    private void showBMIDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("BMI Dialog");
        builder.setMessage("Enter your weight and height");

        final EditText weightEditText = new EditText(this);
        weightEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        weightEditText.setHint("Weight (kg)");

        final EditText heightEditText = new EditText(this);
        heightEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        heightEditText.setHint("Height (m)");

        weightEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable s) {
                String weightStr = weightEditText.getText().toString().trim();
                if (!weightStr.isEmpty()) {
                    float weight = Float.parseFloat(weightStr);

                    textViewWeightValue.setText(String.valueOf(weight));
                }
            }
        });

        LinearLayout dialogLayout = new LinearLayout(this);
        dialogLayout.setOrientation(LinearLayout.VERTICAL);
        dialogLayout.addView(weightEditText);
        dialogLayout.addView(heightEditText);
        builder.setView(dialogLayout);

        builder.setPositiveButton("Calculate", (dialog, which) -> {
            String weightStr = weightEditText.getText().toString().trim();
            String heightStr = heightEditText.getText().toString().trim();

            if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
                saveWeightValue(Float.parseFloat(weightStr));
                saveHeightValue(Float.parseFloat(heightStr));

                recalculateBMI();
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private String getBMICategory(float bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normal";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else if (bmi >= 30 && bmi < 35) {
            return "Obese";
        } else {
            return "Extremely Obese";
        }
    }

    private void showWeightDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Weight Dialog");
        builder.setMessage("Enter your weight");
        final EditText editText = new EditText(this);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        builder.setView(editText);

        builder.setPositiveButton("Save", (dialog, which) -> {
            String weightStr = editText.getText().toString().trim();
            if (!weightStr.isEmpty()) {
                float weightValue = Float.parseFloat(weightStr);
                textViewWeightValue.setText(String.valueOf(weightValue));

                saveWeightValue(weightValue);
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private float getWeightValue() {
        return weightValue;
    }

    private void saveWeightValue(float newWeightValue) {
        textViewWeightValue.setText(String.valueOf(newWeightValue));
        userprofile.weight = String.valueOf(newWeightValue);
        weightValue = newWeightValue;
        recalculateBMI();
    }

    private void displayCaloriesChart() {
        BarDataSet dataSet = new BarDataSet(caloriesEntries, "Calories Burned");
        dataSet.setColor(Color.parseColor("#2EB8B8"));

        BarData barData = new BarData(dataSet);
        barChartCalories.setData(barData);
        barChartCalories.setFitBars(true);
        barChartCalories.setDrawGridBackground(false);
        barChartCalories.getDescription().setEnabled(false);
        barChartCalories.animateY(1000);
        barChartCalories.invalidate();
    }

    private void displayExercisesChart() {
        BarDataSet dataSet = new BarDataSet(exerciseEntries, "Number of Exercises");
        dataSet.setColor(Color.parseColor("#2EB8B8"));

        BarData barData = new BarData(dataSet);
        barChartExercises.setData(barData);
        barChartExercises.setFitBars(true);
        barChartExercises.setDrawGridBackground(false);
        barChartExercises.getDescription().setEnabled(false);
        barChartExercises.animateY(1000);
        barChartExercises.invalidate();
    }

    public void addToCalories(){
        caloriesEntries.add(new BarEntry(caloriesEntries.size(), totalCaloriesBurned));
    }
    public void addToExercises(){
            exerciseEntries.add(new BarEntry(exerciseEntries.size(), totalWorkouts));
    }
    
    //add these methods to exercise
    public void addTotalWorkout(){
        totalWorkouts++;
    }
    public void addTotalCalories(int calories){
        totalCaloriesBurned += calories;
    }
    public void addMinutes(int seconds){
        totalMinutes += (seconds / 60);
    }
}