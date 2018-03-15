package com.example.mbarr.discountapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText originalPriceET;
    private EditText discountPercentageET;
    private TextView finalPriceTV;

    private double originalPrice = 0.0;
    private double discountPercentage = 0.0;
    private double finalPrice = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        originalPriceET = findViewById(R.id.originalPriceET);
        discountPercentageET = findViewById(R.id.percentageOffET);
        finalPriceTV = findViewById(R.id.finalPriceTV);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    originalPrice = Double.parseDouble(originalPriceET.getText().toString());
                    discountPercentage = Double.parseDouble(discountPercentageET.getText().toString());
                }
                catch (NumberFormatException e) {
                    originalPrice = 0.0;
                    discountPercentage = 0.0;
                }

                finalPrice = originalPrice * (1 - (discountPercentage / 100.0));

                finalPriceTV.setText("Final Price : $ " + String.format("%.2f", finalPrice) + "");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        discountPercentageET.addTextChangedListener(textWatcher);




    }

}
