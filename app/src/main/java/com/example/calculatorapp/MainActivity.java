package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView answerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answerText = findViewById(R.id.output);
        String firstNum = "";
        String secondNum = "";
        String expression = "";
        String output = "";
    }

    public String expressionClicked(View view) {
        Button button = (Button)view;
        String expression = button.getText().toString();
        answerText.setText(answerText.getText() + " " + expression + " ");
        return expression;
    }

    public Double numClicked(View view) {

        Button button = (Button)view;
        String number = button.getText().toString();
        answerText.setText(answerText.getText().toString() + number);

        if (number.equals("𝝿")) {
            number = "3.14";
        }

        if (number.equals("e")) {
            number = "2.72";
        }
        return Double.parseDouble(number);
    }

    public void calculate(String param1, String param2, String exp) {
        Double result;
        Double number1 = Double.parseDouble(param1);
        Double number2 = Double.parseDouble(param2);


        if (exp.equals("/")) {
            result = number1/number2;
        }

        else if (exp.equals("X")) {
            result = number1 * number2;
        }

        else if (exp.equals("+")) {
            result = number1 + number2;
        }

        else if (exp.equals("-")) {
            result = number1 - number2;
        }

        else {
            result = number1 % number2;
        }

    }



}