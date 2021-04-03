package com.zomb.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;

import static java.lang.Math.*;

public class MainActivity extends AppCompatActivity {
    // Initialize variables
    private final String KEY_SAVED_CALCULATION = "savedCalculation";
    private final String KEY_NUM1 = "savedNum1";
    private final String KEY_NUM2 = "savedNum2";
    private final String KEY_HISTORY = "savedHistory";
    private String mSavedCalculation;
    private String mSavedHistory;

    double num1, num2, result, prcnt;
    TextView display, statement;
    boolean deci, percent, isNewClick;
    String answer, operation;
    StringBuilder str = new StringBuilder();
    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_decimal, btn_add, btn_subtract, btn_multiply, btn_divide, btn_plusminus, btn_percent, btn_root, btn_sqr, btn_1x, btn_ce, btn_c, btn_back, btn_equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (savedInstanceState != null) {
//            mSavedCalculation = savedInstanceState.getString(KEY_SAVED_CALCULATION);
//            mSavedHistory = savedInstanceState.getString(KEY_HISTORY);
//            num1 = savedInstanceState.getDouble(KEY_NUM1);
//            num2 = savedInstanceState.getDouble(KEY_NUM2);
//            display.setText(mSavedCalculation);
//            statement.setText(mSavedHistory);
//
//        }

        percent = false;
        deci = false;
        isNewClick = true;  // sets whether or not the button click is the first click. Gets rid of the default 0 when numbers are entered

        // Initialize all buttons
        btn_1 = (Button) findViewById(R.id.btn_one);
        btn_2 = (Button) findViewById(R.id.btn_two);
        btn_3 = (Button) findViewById(R.id.btn_three);
        btn_4 = (Button) findViewById(R.id.btn_four);
        btn_5 = (Button) findViewById(R.id.btn_five);
        btn_6 = (Button) findViewById(R.id.btn_six);
        btn_7 = (Button) findViewById(R.id.btn_seven);
        btn_8 = (Button) findViewById(R.id.btn_eight);
        btn_9 = (Button) findViewById(R.id.btn_nine);
        btn_0 = (Button) findViewById(R.id.btn_zero);
        btn_plusminus = (Button) findViewById(R.id.btn_plusminus);
        btn_decimal = (Button) findViewById(R.id.btn_point);
        btn_percent = (Button) findViewById(R.id.btn_percent);
        btn_root = (Button) findViewById(R.id.btn_root);
        btn_sqr = (Button) findViewById(R.id.btn_square);
        btn_1x = (Button) findViewById(R.id.btn_onex);
        btn_ce = (Button) findViewById(R.id.btn_ce);
        btn_c = (Button) findViewById(R.id.btn_c);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_subtract = (Button) findViewById(R.id.btn_subtract);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_divide = (Button) findViewById(R.id.btn_divide);

        // sets the main display and the line showing calculations
        display = findViewById(R.id.display);
        statement = findViewById(R.id.calculation); // fixme: create a stringbuilder to store the entire calculation then save it to file

        //restore state
        if (savedInstanceState != null) {
//            mSavedCalculation = savedInstanceState.getString(KEY_SAVED_CALCULATION);
//            mSavedHistory = savedInstanceState.getString(KEY_HISTORY);
//            num1 = savedInstanceState.getDouble(KEY_NUM1);
//            num2 = savedInstanceState.getDouble(KEY_NUM2);
//            display.setText(mSavedCalculation);
//            statement.setText(mSavedHistory);

        }

    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        final TextView displayText = (TextView) findViewById(R.id.display);
        CharSequence cs = displayText.getText();
        outState.putCharSequence("hist", cs);
//        outState.putString(KEY_SAVED_CALCULATION, mSavedCalculation);
//        outState.putDouble(KEY_NUM1, num1);
//        outState.putDouble(KEY_NUM2, num2);
//        mSavedHistory = str.toString();
//        outState.putString(KEY_HISTORY, mSavedHistory);
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        final TextView displayText = (TextView) findViewById(R.id.display);
        CharSequence cs = savedInstanceState.getCharSequence("hist");

        displayText.setText(cs);
//        mSavedCalculation = savedInstanceState.getString(KEY_SAVED_CALCULATION);
//        mSavedHistory = savedInstanceState.getString(KEY_HISTORY);
//        num1 = savedInstanceState.getDouble(KEY_NUM1);
//        num2 = savedInstanceState.getDouble(KEY_NUM2);
//        display.setText(mSavedCalculation);
//        statement.setText(mSavedHistory);
//
    }

    public void btn1Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_1.getText().toString());
        display.setText(number);
//        str.append(number);
        
    }
    public void btn2Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_2.getText().toString());
        display.setText(number);
//        str.append(number);
    }
    public void btn3Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_3.getText().toString());
        display.setText(number);
//        str.append(number);
    }
    public void btn4Click(View view) {
        if (isNewClick) {
            display.setText("");
            isNewClick = false;
            statement.setText("");
        }
        String number = (display.getText().toString() + btn_4.getText().toString());
        display.setText(number);
//        str.append(number);
    }
    public void btn5Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_5.getText().toString());
        display.setText(number);
//        str.append(number);
    }
    public void btn6Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_6.getText().toString());
        display.setText(number);
//        str.append(number);
    }
    public void btn7Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_7.getText().toString());
        display.setText(number);
//        str.append(number);
    }
    public void btn8Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_8.getText().toString());
        display.setText(number);
//        str.append(number);
    }
    public void btn9Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_9.getText().toString());
        display.setText(number);
//        str.append(number);
    }
    public void btn0Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_0.getText().toString());
        display.setText(number);
//        str.append(number);
    }
    public void btnPercentClick(View view) {
        num2 = Double.parseDouble(display.getText().toString());
        prcnt = (num1 * (num2 / 100));
        display.setText(String.valueOf(prcnt));
        str.append(display.getText().toString());
        percent = true;
    }
    public void btnRootClick(View view) {
        num1 = Double.parseDouble(display.getText().toString());
        double op = Double.parseDouble(display.getText().toString());
        op = sqrt(op);
        display.setText(String.valueOf(op));
        str.append(display.getText().toString());
        isNewClick = true;
    }
    public void btnSqrClick(View view) {
        double op = Double.parseDouble(display.getText().toString());
        op = (op * op);
        display.setText(String.valueOf(op));
        str.append(display.getText().toString());
        isNewClick = true;
    }
    public void btnOneXClick(View view) {
        double op = Double.parseDouble(display.getText().toString());
        op = (1 / op);
        display.setText(String.valueOf(op));
        str.append(display.getText().toString());
        isNewClick = true;
    }
    public void btnCeClick(View view) {
        display.setText("0");
        isNewClick = true;
    }
    public void btnCClick(View view) {
        display.setText("0");
        num1 = 0.0;
        num2 = 0.0;
        isNewClick = true;
        str.delete(0, str.length() - 1);
        statement.setText("");
    }
    public void btnBackClick(View view) {
        String backspace = null;

        if (display.getText().length() > 0) {
            StringBuilder back = new StringBuilder(display.getText());
            back.deleteCharAt(display.getText().length() - 1);
            backspace = back.toString();
            display.setText(backspace);
//            str.deleteCharAt(display.getText().length() - 1);
        }
        isNewClick = true;
    }
    public void btnDivideClick(View view) {
        num1 = Double.parseDouble(display.getText().toString());
        operation = "/";
        str.append(num1 + " " + operation + " ");
        isNewClick = true;
    }
    public void btnMultClick(View view) {
        num1 = Double.parseDouble(display.getText().toString());
        operation = "*";
        str.append(num1 + " " + operation + " ");
        isNewClick = true;
    }
    public void btnAddClick(View view) {
        num1 = Double.parseDouble(display.getText().toString());
        operation = "+";
        str.append(num1 + " " + operation + " ");
        isNewClick = true;
    }
    public void btnSubClick(View view) {
        num1 = Double.parseDouble(display.getText().toString());
        operation = "-";
        str.append(num1 + " " + operation + " ");
        isNewClick = true;
    }
    public void btnPlusMinClick(View view) {
        double op = Double.parseDouble(display.getText().toString());
        op = op * (-1);
        display.setText(String.valueOf(op));
        str.append(display.getText().toString());
    }
    public void btnDecClick(View view) {
        if (!display.getText().toString().contains(".")) {
            String number = (display.getText().toString() + btn_decimal.getText().toString());
            display.setText(number);
            str.append(display.getText().toString());
        }
    }

    public void btnEqualClick(View view) throws IOException {
        num2 = Double.parseDouble(display.getText().toString());

        if (operation == "+") {
            if (isNewClick) {
                num1 = result;
            }
            if (percent == true) {
                result = prcnt + num1;
            } else {
                result = num1 + num2;
            }
            answer = String.valueOf(result);
            display.setText(answer);
            isNewClick = true;
            percent = false;
        } else if (operation == "-") {
            if (percent == true) {
                result = num1 - prcnt;
            } else {
                result = num1 - num2;
            }
            answer = String.valueOf(result);
            display.setText(answer);
            isNewClick = true;
            percent = false;
        } else if (operation == "/") {
            if (percent == true) {
                result = num1 / prcnt;
            } else {
                result = num1 / num2;
            }
            answer = String.valueOf(result);
            display.setText(answer);
            isNewClick = true;
            percent = false;
        } else if (operation == "*") {
            if (percent == true) {
                result = prcnt * num1;
            } else {
                result = num1 * num2;
            }
            answer = String.valueOf(result);
            display.setText(answer);
            isNewClick = true;
            percent = false;
        }
        str.append( num2 + " " + "=" + " " + answer + " ");
        statement.setText(str);
        writeToInternalFile(str.toString());
//        FileOutputStream hist = null;
//        hist = openFileOutput("Calculator History", MODE_APPEND);
//        hist.write(str.toString().getBytes());
    }

    public void btnHistClick(View view) {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
    // fixme: make spaces between numbers and operators
    private void writeToInternalFile(String str) throws IOException {
        FileOutputStream outputStream = openFileOutput("history", Context.MODE_APPEND);
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println(str);
        writer.close();
    }


    // todo: move this to HistoryActivity
    private String readFromInternalFile() throws IOException {
        FileInputStream inputStream = openFileInput("history");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder stringBuilder = new StringBuilder();

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }
        }
        finally {
            reader.close();
        }

        return stringBuilder.toString();
    }


    // todo: add history layout
    // todo: add state handling

}