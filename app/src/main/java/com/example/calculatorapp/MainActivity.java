package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView output = findViewById(R.id.output);
    private boolean equalPressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void numPressed(View view) {
        int id = view.getId();
        output.setText(id + "test");
    }

//    public String expPressed(View view) {
//
//    }


    public void clear() {
        output.setText("");
    }


}