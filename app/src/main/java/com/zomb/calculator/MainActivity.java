package com.zomb.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.*;

public class MainActivity<places> extends AppCompatActivity {
    public static final String KEY_DISPLAY = "KEY_DISPLAY";
    public static final String KEY_STATEMENT = "KEY_STATEMENT";

    // Initialize variables
    double num1, num2, result, prcnt;
    TextView display, statement;
    boolean deci, percent, isNewClick;
    String answer, operation;
    StringBuilder str = new StringBuilder();
    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_decimal, btn_add, btn_subtract, btn_multiply, btn_divide, btn_plusminus, btn_percent, btn_root, btn_sqr, btn_1x, btn_ce, btn_c, btn_back;

    BigDecimal n1 = new BigDecimal(num1);
    BigDecimal n2 = new BigDecimal(num2);
    BigDecimal res = new BigDecimal("0");
    BigDecimal per = new BigDecimal(prcnt);
    BigDecimal oper = new BigDecimal("0");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializes everything (no percent sign, no decimal, and the next click will be a new click)
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
        display = (TextView) findViewById(R.id.display);
        statement = (TextView) findViewById(R.id.calculation);

        if (savedInstanceState != null) {
            display.setText(savedInstanceState.getString(KEY_DISPLAY));
            statement.setText(savedInstanceState.getString(KEY_STATEMENT));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String savedDisplay = display.getText().toString();
        String savedStatement = statement.getText().toString();
        outState.putString(KEY_DISPLAY, savedDisplay);
        outState.putString(KEY_STATEMENT, savedStatement);
    }

    public void btn1Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_1.getText().toString());
        display.setText(number);
    }

    public void btn2Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_2.getText().toString());
        display.setText(number);
    }
    public void btn3Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_3.getText().toString());
        display.setText(number);
    }
    public void btn4Click(View view) {
        if (isNewClick) {
            display.setText("");
            isNewClick = false;
            statement.setText("");
        }
        String number = (display.getText().toString() + btn_4.getText().toString());
        display.setText(number);
    }
    public void btn5Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_5.getText().toString());
        display.setText(number);
    }
    public void btn6Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_6.getText().toString());
        display.setText(number);
    }
    public void btn7Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_7.getText().toString());
        display.setText(number);
    }
    public void btn8Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_8.getText().toString());
        display.setText(number);
    }
    public void btn9Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_9.getText().toString());
        display.setText(number);
    }
    public void btn0Click(View view) {
        if (isNewClick) {
            display.setText("");
            statement.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_0.getText().toString());
        display.setText(number);
    }
    //fixme: it's all fucked up
    public void btnPercentClick(View view) {
        num2 = Double.parseDouble(display.getText().toString());
        n2 = BigDecimal.valueOf(num2);
        n2.setScale(6, RoundingMode.HALF_UP);
//        per = (n1.multiply(n2.divide(BigDecimal.valueOf(100))));
        per = n2.divide(BigDecimal.valueOf(100.0));
        per = per.multiply(n1);
        display.setText(String.valueOf(per));
        percent = true;
    }

    public void btnRootClick(View view) throws IOException {
        num1 = Double.parseDouble(display.getText().toString());
        n1 = BigDecimal.valueOf(num1);
        double op = Double.parseDouble(display.getText().toString());
        op = sqrt(op);
        oper = BigDecimal.valueOf(op);
        display.setText(String.valueOf(oper));
        str.append("\u221A(" + n1 + ")");
        statement.setText(str.toString());
        writeToInternalFile(str.toString());
        isNewClick = true;
    }
    public void btnSqrClick(View view) throws IOException {
        num1 = Double.parseDouble(display.getText().toString());
        n1 = BigDecimal.valueOf(num1);
        double op = Double.parseDouble(display.getText().toString());
        op = (op * op);
        oper = BigDecimal.valueOf(op);
        display.setText(String.valueOf(oper));
        str.append("sqr(" + n1 + ")" + " = " + oper);
        statement.setText(str.toString());
        writeToInternalFile(str.toString());
        isNewClick = true;
    }
    public void btnOneXClick(View view) throws IOException {
        num1 = Double.parseDouble(display.getText().toString());
        n1 = BigDecimal.valueOf(num1);
        double op = Double.parseDouble(display.getText().toString());
        op = (1 / op);
        oper = BigDecimal.valueOf(op);
        display.setText(String.valueOf(oper));
        str.append("1/(" + n1 + ")" + " = " + oper);
        statement.setText(str.toString());
        writeToInternalFile(str.toString());
        isNewClick = true;
    }
    public void btnCeClick(View view) {
        display.setText("0");
        isNewClick = true;
    }
    public void btnCClick(View view) {
        display.setText("0");
        num1 = 0.0;
        n1 = BigDecimal.valueOf(0.0);
        num2 = 0.0;
        n2 = BigDecimal.valueOf(0.0);
        if (str.length() != 0) {
            str.delete(0, str.length() - 1);
        }
        statement.setText("");
        isNewClick = true;
    }
    public void btnBackClick(View view) {
        String backspace = null;

        if (display.getText().length() > 0) {
            StringBuilder back = new StringBuilder(display.getText());
            back.deleteCharAt(display.getText().length() - 1);
            backspace = back.toString();
            display.setText(backspace);
        }
        isNewClick = true;
    }
    public void btnDivideClick(View view) {
        num1 = Double.parseDouble(display.getText().toString());
        n1 = BigDecimal.valueOf(num1);
        n1.setScale(6, RoundingMode.HALF_UP);
        operation = "/";
        str.append(n1 + " " + operation + " ");
        statement.setText(str.toString());
        isNewClick = true;
    }
    public void btnMultClick(View view) {
        num1 = Double.parseDouble(display.getText().toString());
        n1 = BigDecimal.valueOf(num1);
        operation = "*";
        str.append(n1 + " " + operation + " ");
        isNewClick = true;
        statement.setText(str.toString());
    }
    public void btnAddClick(View view) {
        num1 = Double.parseDouble(display.getText().toString());
        n1 = BigDecimal.valueOf(num1);
        operation = "+";
        str.append(n1 + " " + operation + " ");
        statement.setText(str.toString());
        isNewClick = true;
    }
    public void btnSubClick(View view) {
        num1 = Double.parseDouble(display.getText().toString());
        n1 = BigDecimal.valueOf(num1);
        operation = "-";
        str.append(n1 + " " + operation + " ");
        statement.setText(str.toString());
        isNewClick = true;
    }
    public void btnPlusMinClick(View view) {
        double op = Double.parseDouble(display.getText().toString());
        op = op * (-1);
        display.setText(String.valueOf(op));
        str.append(display.getText().toString());
        statement.setText(str.toString());
    }
    // fixme: history prints first digit and decimal twice
    public void btnDecClick(View view) {
        if (!display.getText().toString().contains(".")) {
            String number = (display.getText().toString() + btn_decimal.getText().toString());
            display.setText(number);
            str.append(display.getText().toString());
        }
    }

    // fixme: it's crashing again when equals is pressed when there is no calculation
    public void btnEqualClick(View view) throws IOException {
        num2 = Double.parseDouble(display.getText().toString());
        n2 = BigDecimal.valueOf(num2);

        switch (operation) {
            case "+":
                calculateOperation(n1.add(per), n1.add(n2));
                break;
            case "-":
                calculateOperation(n1.subtract(per), n1.subtract(n2));
                break;
            case "/":
                calculateOperation(n1.divide(per), n1.divide(n2));
                break;
            case "*":
                calculateOperation(per.multiply(n1), n1.multiply(n2));
                break;
            default:
                return;

        }
        str.append( n2 + " = " + answer + " ");
        statement.setText(str);
        writeToInternalFile(str.toString());
        str.delete(0, str.length() - 1);
    }

    private void calculateOperation(BigDecimal v, BigDecimal v2) {
        if (percent == true) {
            res = v;
        } else {
            res = v2;
        }
        res.setScale(6, RoundingMode.HALF_UP);
        answer = String.valueOf(res);
        display.setText(answer);
        isNewClick = true;
        percent = false;
    }

    public void btnHistClick(View view) {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
    private void writeToInternalFile(String str) throws IOException {
        FileOutputStream outputStream = openFileOutput("history", Context.MODE_APPEND);
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println(str);
        writer.close();
    }

}