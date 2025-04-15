package com.example.radhikasingh_cse7_q1;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Spinner fromSpinner, toSpinner;
    EditText inputValue;
    Button convertButton;
    TextView resultText;

    String[] units = {"Feet", "Inches", "Centimeters", "Meters", "Yards"};
    HashMap<String, Double> toMeterFactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.inputValue);
        fromSpinner = findViewById(R.id.fromSpinner);
        toSpinner = findViewById(R.id.toSpinner);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, units);
        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);

        // Conversion factors to meters
        toMeterFactor = new HashMap<>();
        toMeterFactor.put("Feet", 0.3048);
        toMeterFactor.put("Inches", 0.0254);
        toMeterFactor.put("Centimeters", 0.01);
        toMeterFactor.put("Meters", 1.0);
        toMeterFactor.put("Yards", 0.9144);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });
    }

    private void convert() {
        String fromUnit = fromSpinner.getSelectedItem().toString();
        String toUnit = toSpinner.getSelectedItem().toString();
        String input = inputValue.getText().toString();

        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
            return;
        }

        double value = Double.parseDouble(input);
        double valueInMeters = value * toMeterFactor.get(fromUnit);
        double convertedValue = valueInMeters / toMeterFactor.get(toUnit);

        resultText.setText(String.format("%.4f %s", convertedValue, toUnit));
    }
}
