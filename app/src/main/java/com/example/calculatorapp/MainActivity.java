package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView answerText;
    private String param1;
    private String param2;
    private String expression;
    private boolean answerInText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answerText = findViewById(R.id.output);
        param1 = "";
        param2 = "";
        expression = "";
        answerInText = false;
    }

    public void expressionClicked(View view) {
        Button button = (Button) view;
        String exp = button.getText().toString();

        if (exp.equals(".")) {
            answerText.setText(answerText.getText() + exp);
        } else {
            answerText.setText(answerText.getText() + " " + exp + " ");

            expression = expression;
        }
    }

    public void numClicked(View view) {

        if (answerInText) {
            clearAnswerText(view);
            answerInText = false;
        }

        Button button = (Button)view;
        String number = button.getText().toString();
        answerText.setText(answerText.getText().toString() + number);
    }

    public void calculate(View view) {
        char[] expressions = {'+', '-', 'X', '/', '%'};
        Double result;
        String input = answerText.getText().toString();
        int expressionIndex = -1;

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < expressions.length; j++) {
                if (input.charAt(i) == expressions[j]) {
                    expressionIndex = i;
                    expression = Character.toString(expressions[j]);
                }
            }
        }

        if (expressionIndex == -1) {
            answerText.setText("Syntax error");
        }

        else {

            param1 = input.substring(0, expressionIndex - 1);
            param2 = input.substring(expressionIndex + 1);

            int indexEOne = param1.indexOf("e");
            int indexPiOne = param1.indexOf("\uD835\uDF7F");
            int indexETwo = param2.indexOf("e");
            int indexPiTwo = param2.indexOf("\uD835\uDF7F");

            if (indexEOne > -1 || indexPiOne > -1) {
                if (indexPiOne > -1) {
                    param1 = param1.substring(0, indexPiOne);
                    Double coeff;
                    if (param1.length() == 0) {
                        coeff = 1.0;
                    }
                    else {
                        coeff = Double.parseDouble(param1);
                    }

                    coeff *=3.142;
                    param1 = Double.toString(coeff);
                }

                if (indexEOne > -1) {
                    param1 = param1.substring(0, indexEOne);
                    Double coeff;
                    if (param1.length() == 0) {
                        coeff = 1.0;
                    }
                    else {
                        coeff = Double.parseDouble(param1);
                    }

                    coeff *= 2.718;
                    param1 = Double.toString(coeff);
                }
            }

            if (indexETwo > -1 || indexPiTwo > -1) {
                if (indexPiTwo > -1) {
                    param2 = param2.substring(0, indexPiTwo);
                    Double coeff;
                    if (param2.length() == 0) {
                        coeff = 1.0;
                    }
                    else {
                        coeff = Double.parseDouble(param2);
                    }

                    coeff *= 3.142;
                    param2 = Double.toString(coeff);
                }

                if (indexETwo > -1) {
                    param2 = param2.substring(0, indexETwo);
                    Double coeff;
                    if (param2.length() == 0) {
                        coeff = 1.0;
                    }
                    else {
                        coeff = Double.parseDouble(param2);
                    }
                    coeff *= 2.718;
                    param2 = Double.toString(coeff);
                }
            }

            if (param2.equals("") || param1.equals("")) {
                answerText.setText("Syntax error");
            }

            else {

                Double number1 = Double.parseDouble(param1);
                Double number2 = Double.parseDouble(param2);

                if (expression.equals("/")) {
                    result = number1 / number2;
                } else if (expression.equals("X")) {
                    result = number1 * number2;
                } else if (expression.equals("+")) {
                    result = number1 + number2;
                } else if (expression.equals("-")) {
                    result = number1 - number2;
                } else {
                    result = number1 % number2;
                }

                result = Math.round(result * 1000.0) / 1000.0;

                answerText.setText(result.toString());

                resetParameters(view);
            }
        }

        answerInText = true;
    }

    public void clearAnswerText(View view) {
        answerText.setText("");
    }

    public void resetParameters(View view) {
        param1 = "";
        param2 = "";
        expression = "";
    }
}