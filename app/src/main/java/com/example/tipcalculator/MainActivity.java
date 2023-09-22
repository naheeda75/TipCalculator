package com.example.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button15, button18, button20;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button15 = findViewById(R.id.button15);
        button18 = findViewById(R.id.button18);
        button20 = findViewById(R.id.button20);
        resultTextView = findViewById(R.id.resultTextView);

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTipAndTotal(0.15);
            }
        });

        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTipAndTotal(0.18);
            }
        });

        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTipAndTotal(0.20);
            }
        });
    }

    private void calculateTipAndTotal(double percentage) {
        try {
            double amount = Double.parseDouble(editText.getText().toString());
            double tip = percentage * amount;
            double total = amount + tip;
            String formattedTip = String.format("Tip: $%.2f", tip);
            String formattedTotal = String.format("Total Bill: $%.2f", total);
            String result = formattedTip + ", " + formattedTotal;
            resultTextView.setText(result);
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input");
        }
    }
}
