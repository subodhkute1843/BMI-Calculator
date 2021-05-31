package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button mcalculatebmi;

    TextView mcurrentHeight;
    TextView mcurrentAge, mcurrentWeight;
    ImageView mincrementWeight, mincrementAge, mdecremenetWeight, mdecremenetAge;
    SeekBar mseekbarforHeight;
    RelativeLayout mmale, mfemale;

    int intweight = 55;
    int intage = 22;
    int currentprogress;

    String mintprogress = "170";
    String typeofuser = "0";
    String weight2 = "55";
    String age2 = " 22";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        mcurrentAge = findViewById(R.id.currentAge);
        mcurrentWeight = findViewById(R.id.currentWeight);
        mcurrentHeight = findViewById(R.id.currentHeight);
        mincrementAge = findViewById(R.id.incrementAge);
        mincrementWeight = findViewById(R.id.incrementWeight);
        mdecremenetAge = findViewById(R.id.decrementAge);
        mdecremenetWeight = findViewById(R.id.decrementWeight);
        mseekbarforHeight = findViewById(R.id.seekBar4Height);
        mmale = findViewById(R.id.male);
        mfemale = findViewById(R.id.female);

        //SET OR REMOVE FOCUS
        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeofuser = "Male";
            }
        });

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeofuser = "Female";
            }
        });


        //INCREASE/DECREASE

        //set maximum limit for seekbar
        mseekbarforHeight.setMax(300);
        //set by default
        mseekbarforHeight.setProgress(170);
        //on change listener
        mseekbarforHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress = progress;
                //its not posible to set int value to text view thats y string type variable
                mintprogress = String.valueOf(currentprogress);
                mcurrentHeight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mincrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage + 1;    //on click it should be increase by 1
                age2 = String.valueOf(intage);
                mcurrentAge.setText(age2);
            }
        });

        mincrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight + 1;    //on click it should be increase by 1
                weight2 = String.valueOf(intweight);
                mcurrentWeight.setText(weight2);
            }
        });

        mdecremenetAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage - 1;    //on click it should be decrease by 1
                age2 = String.valueOf(intage);
                mcurrentAge.setText(age2);
            }
        });

        mdecremenetWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight - 1;    //on click it should be decrease by 1
                weight2 = String.valueOf(intweight);
                mcurrentWeight.setText(weight2);
            }
        });

        //CALCULATE BMI
        mcalculatebmi = findViewById(R.id.calcuulateBMI);

        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (typeofuser.equals("0")) {
                    Toast.makeText(MainActivity.this, "Select Your Gender First", Toast.LENGTH_SHORT).show();
                } else if (mintprogress.equals("0")) {
                    Toast.makeText(MainActivity.this, "Set Your Height", Toast.LENGTH_SHORT).show();
                } else if (intage == 0 || intage < 0) {
                    Toast.makeText(MainActivity.this, "Age is Incorrect", Toast.LENGTH_SHORT).show();
                } else if (intweight == 0 || intweight < 0) {
                    Toast.makeText(MainActivity.this, "Weight is Incorrect", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, BMI_Activity.class);
                    intent.putExtra("gender", typeofuser);
                    intent.putExtra("height", mintprogress);
                    intent.putExtra("age", age2);
                    intent.putExtra("weight", weight2);
                    startActivity(intent);
                }


            }
        });
    }
}
