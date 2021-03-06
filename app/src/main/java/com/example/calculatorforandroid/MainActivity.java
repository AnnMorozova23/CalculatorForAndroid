package com.example.calculatorforandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int numberId[] = new int[]{
                R.id.key_0,
                R.id.key_1,
                R.id.key_2,
                R.id.key_3,
                R.id.key_4,
                R.id.key_5,
                R.id.key_6,
                R.id.key_7,
                R.id.key_8,
                R.id.key_9

        };

        int actionId[] = new int[]{
                R.id.key_divide,
                R.id.key_minus,
                R.id.key_multiply,
                R.id.key_percent,
                R.id.key_sum,
                R.id.key_drop,
                R.id.key_result

        };

        calculator = new Calculator();

        View.OnClickListener actionListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onActionPressed(view.getId());
            }
        };

        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumPressed(view.getId());
            }
        };

        for (int i = 0; i <actionId.length ; i++) {
            findViewById(actionId[i]).setOnClickListener(actionListener);
        }

        for (int i = 0; i < numberId.length; i++) {
            findViewById(numberId[i]).setOnClickListener(numberListener);
        }
    }
}