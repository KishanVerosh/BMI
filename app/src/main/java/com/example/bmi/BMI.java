package com.example.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BMI extends AppCompatActivity {

    TextView tv,tv1;
    double age,hi,weh,bmi,bmiR;

    public static String key1 = "UNIQUIKEY1";
    public static String key2 = "UNIQUIKEY2";
    public static String key3 = "UNIQUIKEY3";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        tv = findViewById(R.id.textView);
        tv1 = findViewById(R.id.textView2);

        Intent intent = getIntent();

        age = Double.parseDouble(intent.getStringExtra(key1));
        hi = Double.parseDouble(intent.getStringExtra(key2))/100;
        weh = Double.parseDouble(intent.getStringExtra(key3));

        bmi = weh/(hi*hi);
        bmiR = Math.ceil(bmi*100);
        tv.setText(String.valueOf(bmiR/100+" kg/m²"));
        tv.setTextColor(getResources().getColor(R.color.black));

        if(bmi<16){
            tv1.setText("Severe Thinness");
            tv1.setTextColor(getResources().getColor(R.color.dark_red));
        } else if (bmi<17 && bmi>=16) {
            tv1.setText("Moderate Thinness");
            tv1.setTextColor(getResources().getColor(R.color.dark_red));
        }else if (bmi<18.5 && bmi>=17) {
            tv1.setText("Mild Thinness");
            tv1.setTextColor(getResources().getColor(R.color.yellow));
        }else if (bmi<25 && bmi>=18.5) {
            tv1.setText("Normal");
            tv1.setTextColor(getResources().getColor(R.color.green));
        }else if (bmi<30 && bmi>=25) {
            tv1.setText("Overweight");
            tv1.setTextColor(getResources().getColor(R.color.yellow));
        }else if (bmi<35 && bmi>=30) {
            tv1.setText("Obese Class I");
            tv1.setTextColor(getResources().getColor(R.color.light_red));
        }else if (bmi<40 && bmi>=35) {
            tv1.setText("Obese Class II");
            tv1.setTextColor(getResources().getColor(R.color.dark_red));
        }else {
            tv1.setText("Obese Class III");
            tv1.setTextColor(getResources().getColor(R.color.dark_red));
        }

    }
}