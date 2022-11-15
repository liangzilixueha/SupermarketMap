package com.liangzilixueha.renjijiaohu.card;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.liangzilixueha.renjijiaohu.R;
import com.liangzilixueha.renjijiaohu.adapter.GodAdapter;
import com.liangzilixueha.renjijiaohu.databinding.ActivityMainBinding;
import com.liangzilixueha.renjijiaohu.databinding.ActivityShoppingCarBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ShoppingCarActivity extends AppCompatActivity {

    private ActivityShoppingCarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_car);
        binding = ActivityShoppingCarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setTitle("购物车");
        ArrayList<ShoppingCar> shoppingCars = new ArrayList<>();
        shoppingCars.add(new ShoppingCar("牛肉", "100$", "66", "1"));
        shoppingCars.add(new ShoppingCar("牛肉", "100$", "66", "1"));
        shoppingCars.add(new ShoppingCar("牛肉", "100$", "66", "1"));
        shoppingCars.add(new ShoppingCar("牛肉", "100$", "66", "1"));
        shoppingCars.add(new ShoppingCar("牛肉", "100$", "66", "1"));
        shoppingCars.add(new ShoppingCar("牛肉", "100$", "66", "1"));
        shoppingCars.add(new ShoppingCar("牛肉", "100$", "66", "1"));
        binding.listView.setAdapter(new GodAdapter<ShoppingCar>(shoppingCars, R.layout
                .shopping_car_item) {
            @Override
            public void bindView(ViewHolder holder, ShoppingCar obj) {
                holder.setText(R.id.name, obj.name);
                holder.setText(R.id.price, obj.price);
                holder.setText(R.id.number, obj.num);
            }
        });

    }

    class ShoppingCar {
        public String name;
        public String price;
        public String num;
        public String img;

        public ShoppingCar(String name, String price, String num, String img) {
            this.name = name;
            this.price = price;
            this.num = num;
            this.img = img;
        }
    }
}