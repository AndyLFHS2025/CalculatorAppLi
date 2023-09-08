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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView output = findViewById(R.id.output);

    }

    public void buttonPressed(View view) {
        int numInput = -1;
        String expression = "";
       if (view.getId() == R.id.one) {
           Log.i("blue monkey", "i");
            numInput = 1;
       }
       else if (view.getId() == R.id.two) {
           Log.i("blue monkey", "ii");
            numInput = 2;
       }
       else if (view.getId() == R.id.three) {
           Log.i("blue monkey", "iii");
           numInput = 3;
       }
       else if (view.getId() == R.id.four) {
           Log.i("blue monkey", "iiii");
           numInput = 4;
       }
       else if (view.getId() == R.id.five) {
           Log.i("blue monkey", "iiiii");
           numInput = 5;
       }
       else if (view.getId() == R.id.six) {
           Log.i("blue monkey", "iiiiii");
           numInput = 6;
       }
       else if (view.getId() == R.id.seven) {
           Log.i("blue monkey", "iiiiiii");
           numInput = 7;
       }
       else if (view.getId() == R.id.eight) {
           Log.i("blue monkey", "iiiiiiii");
           numInput = 8;
       }
       else if (view.getId() == R.id.nine) {
           Log.i("blue monkey", "iiiiiiiii");
           numInput = 9;
       }
       else if (view.getId() == R.id.zero) {
           Log.i("blue monkey", "zero");
           numInput = 0;
       }
       else if (view.getId() == R.id.pi) {
           numInput = 3;
       }

       else if (view.getId() == R.id.plus) {
           expression = "+";
        }
       else if (view.getId() == R.id.minus) {
           expression = "-";
       }
       else if (view.getId() == R.id.multiply) {
           expression = "x";
       }
       else if (view.getId() == R.id.divide) {
           expression = "/";
       }
       else if (view.getId() == R.id.percent) {
           expression = "%";
       }
       else if (view.getId() == R.id.parentheses) {
           expression = "+";
       }



    }

    public void calculate(View view, int param1, int param2, String exp) {

    }



}