package com.example.ha_nguyen_assignment02_shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class CustomerInfo extends AppCompatActivity {
    String brandOutput, modelOutput, dataPlanOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);

        //get the brand and model
        Intent preIntent=getIntent();
        brandOutput=preIntent.getStringExtra("brandOutput");
        modelOutput=preIntent.getStringExtra("modelOutput");
        dataPlanOutput=preIntent.getStringExtra("dataPlanOutput");

        //new city
        ArrayAdapter<String> cityAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.cities));
        AutoCompleteTextView inputCty=(AutoCompleteTextView) findViewById(R.id.inputCity);
        inputCty.setThreshold(1);
        inputCty.setAdapter(cityAdapter);
    }
    public void PlaceOrder(View v){
        Intent intent=new Intent(this,OutputScreen.class);

       EditText input=findViewById(R.id.name);
       intent.putExtra("nameOutput",input.getText().toString()); //name
        intent.putExtra("brandOutput",brandOutput);//brand
        intent.putExtra("modelOutput",modelOutput);//model
        intent.putExtra("dataPlanOutput",dataPlanOutput);
       startActivity(intent);


    }
}
