package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMI_Activity extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;

    TextView mbmiDisplay, mgenderDisplay, mbmiCateogory;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi; //bmi comes in float

    String height, weight;
    float intheight, intweight;
    RelativeLayout mbackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color = \"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        intent = getIntent();

        mbmiDisplay = findViewById(R.id.bmiDisplay);
        mbmiCateogory = findViewById(R.id.bmiCategory);
        mgenderDisplay = findViewById(R.id.genderDisplay);
        mbackground = findViewById(R.id.contentLayout);
        //assign imageview id
        mimageview = findViewById(R.id.imageview);
        mrecalculatebmi = findViewById(R.id.recalcuulateBMI);

        //INTENT
        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        //convert into meter
        intheight = intheight / 100;

        //calculate bmi
        intbmi = intweight / (intheight * intheight);
        mbmi = Float.toString(intbmi);

        if (intbmi < 16) {
            mbmiCateogory.setText("Severe Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        } else if (intbmi < 16.9 && intbmi > 16) {
            mbmiCateogory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        } else if (intbmi < 18.4 && intbmi > 17) {
            mbmiCateogory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        } else if (intbmi < 25 && intbmi > 18.4) {
            mbmiCateogory.setText("All good");
            //mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.ok);
        } else if (intbmi < 29.4 && intbmi > 25) {
            mbmiCateogory.setText("Overweight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        } else {
            mbmiCateogory.setText("Obese Class !");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }

        mgenderDisplay.setText(intent.getStringExtra("gender"));
        mbmiDisplay.setText(mbmi);




        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BMI_Activity.this, MainActivity.class);
                startActivity(intent);


            }
        });
    }
}
