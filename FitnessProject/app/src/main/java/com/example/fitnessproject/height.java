package com.example.fitnessproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class height extends AppCompatActivity {
    EditText weight_EditText , height_EditText ,date_EditText;
    Calendar myCalendar;
    static String weight , height ,dateOfBirth;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height);


        weight_EditText=findViewById(R.id.weight_input);
        height_EditText=findViewById(R.id.height_input);
        myCalendar= Calendar.getInstance();
        next=findViewById(R.id.next_btn_profile);
        date_EditText=findViewById(R.id.date_input);
        DatePickerDialog.OnDateSetListener date1 =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
            }
        };
        date_EditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(height.this,date1,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight=weight_EditText.getText().toString();
                height=height_EditText.getText().toString();
                dateOfBirth=date_EditText.getText().toString();
                System.out.println(weight+"\n"+height+"\n"+dateOfBirth);
                Intent i = new Intent(getApplicationContext(),setgoal.class);
                startActivity(i);

            }
        });
    }

    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        date_EditText.setText(dateFormat.format(myCalendar.getTime()));
    }

}
