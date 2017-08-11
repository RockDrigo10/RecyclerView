package com.example.admin.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 8/10/2017.
 */

public class Food implements Parcelable{
    String dishName;
    int price;
    int calories;
    double rating;

    public Food(String dishName, int price, int calories, double rating) {
        this.dishName = dishName;
        this.price = price;
        this.calories = calories;
        this.rating = rating;
    }

    protected Food(Parcel in) {
        dishName = in.readString();
        price = in.readInt();
        calories = in.readInt();
        rating = in.readDouble();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public String getDishName() { return dishName; }

    public int getPrice() { return price; }

    public int getCalories() { return calories; }

    public double getRating() { return rating; }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dishName);
        dest.writeInt(price);
        dest.writeInt(calories);
        dest.writeDouble(rating);
    }
}
