package com.zomb.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView display;
    boolean isNewClick = true;
    String oldNum, operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
    }


    public void numBtnOnClick(View view) {
        if (isNewClick) {
            display.setText("");
            isNewClick = false;
        }
        String number = display.getText().toString();
        switch (view.getId()) {
            case R.id.btn_one:
                number += "1";
                break;
            case R.id.btn_two:
                number += "2";
                break;
            case R.id.btn_three:
                number += "3";
                break;
            case R.id.btn_four:
                number += "4";
                break;
            case R.id.btn_five:
                number += "5";
                break;
            case R.id.btn_six:
                number += "6";
                break;
            case R.id.btn_seven:
                number += "7";
                break;
            case R.id.btn_eight:
                number += "8";
                break;
            case R.id.btn_nine:
                number += "9";
                break;
            case R.id.btn_zero:
                number += "0";
                break;
            case R.id.btn_point:
                number += ".";
                break;
            case R.id.btn_plusminus:
                number = "-" + number;
                break;

        }

        display.setText(number);
    }

    public void opBtnOnClick(View view) {
        isNewClick = true;
        oldNum = display.getText().toString();

        switch (view.getId()) {
            case R.id.btn_add:
                operator = "+";
                break;
            case R.id.btn_subtract:
                operator = "-";
                break;
            case R.id.btn_multiply:
                operator = "*";
                break;
            case R.id.btn_divide:
                operator = "/";
                break;


        }

    }
}