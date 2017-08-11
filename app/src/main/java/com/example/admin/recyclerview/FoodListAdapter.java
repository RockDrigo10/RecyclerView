package com.example.admin.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ViewHolder>{

    private static final String TAG = "FoodListAdapter";
    List<Food> foodList =  new ArrayList<>();
    Context context;

    public FoodListAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvFoodName;
        TextView tvFoodPrice;
        TextView tvFoodCalories;
        TextView tvFoodRating;

        public ViewHolder(View itemView) {
            super(itemView);
            tvFoodName = (TextView) itemView.findViewById(R.id.tvFoodName);
            tvFoodPrice = (TextView) itemView.findViewById(R.id.tvFoodPrice);
            tvFoodCalories = (TextView) itemView.findViewById(R.id.tvFoodCalories);
            tvFoodRating = (TextView) itemView.findViewById(R.id.tvFoodRating);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodlist_item,parent, false);
        Log.d(TAG, "onCreateViewHolder: " );
        return new ViewHolder(view);
    }
    private int lastPosition = -1;
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: " + position);
        final Food food = foodList.get(position);
        holder.tvFoodName.setText(food.getDishName());
        holder.tvFoodPrice.setText(String.valueOf(food.getPrice()));
        holder.tvFoodCalories.setText(String.valueOf(food.getCalories()));
        holder.tvFoodRating.setText(String.valueOf(food.getRating()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SecondActivity.class);
                intent.putExtra("food",food);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();

    }

}
