package com.example.bmi;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText ageT, hiT, wehT;

    public static String key1 = "UNIQUIKEY1";
    public static String key2 = "UNIQUIKEY2";
    public static String key3 = "UNIQUIKEY3";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ageT = findViewById(R.id.tex1);
        hiT = findViewById(R.id.tex2);
        wehT = findViewById(R.id.tex3);
    }

    public void cal(View viwe) {
        String age = ageT.getText().toString();
        String hi = hiT.getText().toString();
        String weh = wehT.getText().toString();

        try {
            if (Integer.parseInt(age) > 18 && Double.parseDouble(hi) > 0 && Double.parseDouble(weh) > 0) {
                Intent intent = new Intent(getBaseContext(), BMI.class);
                intent.putExtra(key1, age);
                intent.putExtra(key2, hi);
                intent.putExtra(key3, weh);

                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_LONG).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alt = new AlertDialog.Builder(MainActivity.this);
        alt.setTitle("Exit");
        alt.setMessage("Do You Want to Exit From app");

        alt.setPositiveButton("Exit", (dialog, which) -> {
            finish();
        });

        alt.setNegativeButton("Cancel", (dialog, which) -> {
            dialog.cancel();
        });

        AlertDialog alert = alt.create();
        alert.show();
    }
}