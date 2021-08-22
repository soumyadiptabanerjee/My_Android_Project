package com.example.ha_nguyen_assignment02_shoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class DataPlanScreen extends AppCompatActivity {

    public Intent previousIntent;
    public String brandOutput,modelOutput,dataPlanOutput;
    private ArrayList<String> dataset=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_plan_screen);
        previousIntent=getIntent();
        brandOutput=previousIntent.getStringExtra("brandOutput");
        modelOutput=previousIntent.getStringExtra("modelOutput");
        initListItem();
    }
    private void initListItem(){
        dataset.add("ha");
        dataset.add("nguyen");
        initRecyclerView();

    }
    public void toCustomerInfo(View v){
      //  Intent intent=new Intent(this,CustomerInfo.class);
//        intent.putExtra("brandOutput",brandOutput);
//        intent.putExtra("modelOutput",modelOutput);
//        intent.putExtra("dataPlanOutput",dataPlanOutput);
     //   startActivity(intent);
    }
    private void initRecyclerView(){
        RecyclerView recyclerView=findViewById(R.id.data_recycler_view);
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(this,dataset,brandOutput,modelOutput);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
