package com.example.admin.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvFoodName,tvFoodPrice,tvFoodCalories,tvFoodRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvFoodName = (TextView) findViewById(R.id.tvFoodName);
        tvFoodPrice = (TextView) findViewById(R.id.tvFoodPrice);
        tvFoodCalories = (TextView) findViewById(R.id.tvFoodCalories);
        tvFoodRating = (TextView) findViewById(R.id.tvFoodRating);
        Intent intent = getIntent();
        Food food = (Food) intent.getParcelableExtra("food");
        tvFoodName.setText(food.getDishName().toString());
        tvFoodPrice.setText(String.valueOf(food.getPrice()));
        tvFoodCalories.setText(String.valueOf(food.getCalories()));
        tvFoodRating.setText(String.valueOf(food.getRating()));

    }
}
