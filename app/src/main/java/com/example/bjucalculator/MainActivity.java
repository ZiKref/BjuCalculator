package com.example.bjucalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etProteins, etFats, etCarbs;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etProteins = findViewById(R.id.etProteins);
        etFats = findViewById(R.id.etFats);
        etCarbs = findViewById(R.id.etCarbs);
        tvResult = findViewById(R.id.tvResult);
        Button btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v -> calculateCalories());
    }

    private void calculateCalories() {
        try {
            double proteins = Double.parseDouble(etProteins.getText().toString());
            double fats = Double.parseDouble(etFats.getText().toString());
            double carbs = Double.parseDouble(etCarbs.getText().toString());

            double calories = (proteins * 4) + (fats * 9) + (carbs * 4);
            tvResult.setText("Калорийность: " + calories + " ккал");
        } catch (NumberFormatException e) {
            tvResult.setText("Введите корректные данные");
        }
    }
}
