package com.zomb.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

import static java.lang.Math.*;

public class MainActivity extends AppCompatActivity {
    // Initialize variables

    double num1, num2, result, prcnt;
    TextView display, statement;
    boolean add, sub, mult, div, deci, percent, root, sqr, oneX, isNewClick;
    String answer, operation;
    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_decimal, btn_add, btn_subtract, btn_multiply, btn_divide, btn_plusminus, btn_percent, btn_root, btn_sqr, btn_1x, btn_ce, btn_c, btn_back, btn_equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        statement = findViewById(R.id.calculation); // todo: create a stringbuilder to store the entire calculation then save it to file
    }

    public void btn1Click(View view) {
        if (isNewClick) {
            display.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_1.getText().toString());
        display.setText(number);
    }
    public void btn2Click(View view) {
        if (isNewClick) {
            display.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_2.getText().toString());
        display.setText(number);
    }
    public void btn3Click(View view) {
        if (isNewClick) {
            display.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_3.getText().toString());
        display.setText(number);
    }
    public void btn4Click(View view) {
        if (isNewClick) {
            display.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_4.getText().toString());
        display.setText(number);
    }
    public void btn5Click(View view) {
        if (isNewClick) {
            display.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_5.getText().toString());
        display.setText(number);
    }
    public void btn6Click(View view) {
        if (isNewClick) {
            display.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_6.getText().toString());
        display.setText(number);
    }
    public void btn7Click(View view) {
        if (isNewClick) {
            display.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_7.getText().toString());
        display.setText(number);
    }
    public void btn8Click(View view) {
        if (isNewClick) {
            display.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_8.getText().toString());
        display.setText(number);
    }
    public void btn9Click(View view) {
        if (isNewClick) {
            display.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_9.getText().toString());
        display.setText(number);
    }
    public void btn0Click(View view) {
        if (isNewClick) {
            display.setText("");
            isNewClick = false;
        }
        String number = (display.getText().toString() + btn_0.getText().toString());
        display.setText(number);
    }
    public void btnPercentClick(View view) {
        num2 = Double.parseDouble(display.getText().toString());
        prcnt = (num1 * (num2 / 100));
        display.setText(String.valueOf(prcnt));
        percent = true;
//        isNewClick = true;
    }
    public void btnRootClick(View view) {
        double op = Double.parseDouble(display.getText().toString());
        op = sqrt(op);
        display.setText(String.valueOf(op));
        isNewClick = true;
    }
    public void btnSqrClick(View view) {
        double op = Double.parseDouble(display.getText().toString());
        op = (op * op);
        display.setText(String.valueOf(op));
        isNewClick = true;
    }
    public void btnOneXClick(View view) {
        double op = Double.parseDouble(display.getText().toString());
        op = (1 / op);
        display.setText(String.valueOf(op));
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
    }
    public void btnBackClick(View view) {
        String backspace = null;

        if (display.getText().length() > 0) {
            StringBuilder str = new StringBuilder(display.getText());
            str.deleteCharAt(display.getText().length() - 1);
            backspace = str.toString();
            display.setText(backspace);
        }
        isNewClick = true;
    }
    public void btnDivideClick(View view) {
        num1 = Double.parseDouble(display.getText().toString());
        operation = "/";
        isNewClick = true;
    }
    public void btnMultClick(View view) {
        num1 = Double.parseDouble(display.getText().toString());
        operation = "*";
        isNewClick = true;
    }
    public void btnAddClick(View view) {
        num1 = Double.parseDouble(display.getText().toString());
        operation = "+";
        isNewClick = true;
    }
    public void btnSubClick(View view) {
        num1 = Double.parseDouble(display.getText().toString());
        operation = "-";
        isNewClick = true;
    }
    public void btnPlusMinClick(View view) {
        double op = Double.parseDouble(display.getText().toString());
        op = op * (-1);
        display.setText(String.valueOf(op));
    }
    public void btnDecClick(View view) {
        if (!display.getText().toString().contains(".")) {
            String number = (display.getText().toString() + btn_decimal.getText().toString());
            display.setText(number);
        }
    }
    public void btnEqualClick(View view) {
        num2 = Double.parseDouble(display.getText().toString());

        if (operation == "+") {
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
    }

    // todo: add history view
    // todo: add state handling
    // todo: allow for complete answer to fit in display. Round after a certain amount of digits and make the font smaller to allow more digits

}