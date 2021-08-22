package com.example.ha_nguyen_assignment02_shoppingapp;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private ArrayList<String> data_plan_items;
    private Context myContext;
    private String brandOutput,modelOutput;
    public RecyclerViewAdapter(Context myContext,ArrayList<String> data_plan_items,String brandOutput,String modelOutput) {
        this.data_plan_items=data_plan_items;
        this.myContext = myContext;
        this.brandOutput=brandOutput;
        this.modelOutput=modelOutput;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item,parent,false);
        ViewHolder holder=new ViewHolder(view) ;
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
         holder.data_plan_item.setText(data_plan_items.get(position));
         holder.parentLayout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(myContext, data_plan_items.get(position)+" is chosen.", Toast.LENGTH_SHORT).show();
                 Intent intent=new Intent(myContext,CustomerInfo.class);
                 intent.putExtra("dataPlanOutput",data_plan_items.get(position));
                 intent.putExtra("brandOutput",brandOutput);
                 intent.putExtra("modelOutput",modelOutput);
                 myContext.startActivity(intent);
                }
         });
    }

    @Override
    public int getItemCount() {
        return data_plan_items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView data_plan_item;
        LinearLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            data_plan_item= itemView.findViewById(R.id.data_plan_item);
            parentLayout=itemView.findViewById(R.id.parent_layout);
        }
        }
    }

