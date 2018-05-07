package com.burgerwizard.alex.burgerwizard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.burgerwizard.alex.burgerwizard.Functionality.Ingredient;
import com.burgerwizard.alex.burgerwizard.Functionality.Static;
import com.burgerwizard.alex.burgerwizard.Functionality.User;

import java.util.ArrayList;
import java.util.Locale;

public class ActivityCheckOut extends AppCompatActivity {

    private TextView tvResult;
    private TextView tvPrice;
    private TextView tvPrices;
    private User user;
    private ArrayList<Ingredient> ingredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        tvResult = findViewById(R.id.activity_check_out_tv_ingredients);
        tvPrice = findViewById(R.id.activity_check_out_tv_price);
        tvPrices = findViewById(R.id.activity_check_out_tv_prices);

        user = (User) getIntent().getSerializableExtra(Static.USER_EXTRA);
        ingredients = (ArrayList<Ingredient>) getIntent().getSerializableExtra(Static.INGREDIENT_LIST_EXTRA);


        String result = "";
        String prices = "";
        float price = 0.0f;
        for (Ingredient ingredient : ingredients){
            result = result +  String.format(Locale.GERMAN,ingredient.getIdentifier()+"\n");
            prices = prices + String.format(Locale.GERMAN,"%.2f" +"€" + "\n", ingredient.getPrice());
            price = price + ingredient.getPrice();
        }
        tvResult.setText(result);
        tvPrices.setText(prices);
        String priceString = String.format(Locale.GERMAN,"Preis: " + "\t\t" + "%.2f" + "€", price);
        tvPrice.setText(priceString);
    }
}
