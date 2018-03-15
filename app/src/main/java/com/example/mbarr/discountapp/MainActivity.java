package com.example.mbarr.discountapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button calculateBtn =  findViewById(R.id.calculateBT);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText originalPriceET =  findViewById(R.id.originalPriceET);
                EditText discountPercentageET =  findViewById(R.id.percentageOffET);
                TextView finalPriceTV =  findViewById(R.id.finalPriceTV);

                double originalPrice = Double.parseDouble(originalPriceET.getText().toString());
                double discountPercentage = Double.parseDouble(discountPercentageET.getText().toString());
                double finalPrice = originalPrice * (1 - (discountPercentage / 100.0));

                finalPriceTV.setText("Final Price : $ " + String.format("%.2f", finalPrice) + "");
            }
        });
    }

}
