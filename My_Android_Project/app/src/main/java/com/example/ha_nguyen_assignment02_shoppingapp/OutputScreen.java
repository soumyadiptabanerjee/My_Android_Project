package com.example.ha_nguyen_assignment02_shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class OutputScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_screen);
        //get intent
        Intent intent=getIntent();
        //name
        TextView tv=findViewById(R.id.nameOp);
        tv.setText(intent.getStringExtra("nameOutput"));
        //brand
        tv=findViewById(R.id.brandOp);
        tv.setText(intent.getStringExtra("brandOutput"));
        // model
        tv=findViewById(R.id.modelOp);
        tv.setText(intent.getStringExtra("modelOutput"));
        //data plan
        tv=findViewById(R.id.planOp);
        tv.setText(intent.getStringExtra("dataPlanOutput"));



    }
}
