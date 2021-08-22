package com.example.ha_nguyen_assignment02_shoppingapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BrandScreen extends AppCompatActivity {

    Intent brand_screen_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_screen);
        brand_screen_intent=new Intent(this,DataPlanScreen.class);
    }
    public boolean onCreateOptionsMenu(Menu menu ){
        getMenuInflater().inflate(R.menu.brandmenu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        //pass brand value to data plan screen
        brand_screen_intent.putExtra("brandOutput",item.getTitle());
        switch (item.getItemId()){
            case R.id.iphone:
                setContentView(R.layout.iphone_models_layout);
                break;
            case R.id.samsung:
                setContentView(R.layout.samsung_models_layout);
                break;
            default:
                setContentView(R.layout.activity_brand_screen);
                break;
        }
        //radio button
        RadioGroup rg=findViewById(R.id.modelGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup rg,int checkedId){
                int radioId=rg.getCheckedRadioButtonId();
                RadioButton radioBtn=findViewById(radioId);
               brand_screen_intent.putExtra("modelOutput",radioBtn.getText());
            }
        });
        return true;
  }
    public void backClicked(View view) {
        startActivity(new Intent(this,BrandScreen.class));
    }
        public void nextClicked(View v){
    startActivity(brand_screen_intent);
  }

}
