package com.burgerwizard.alex.burgerwizard;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.burgerwizard.alex.burgerwizard.CustomElements.CustomIngredientSelector;
import com.burgerwizard.alex.burgerwizard.Functionality.Ingredient;
import com.burgerwizard.alex.burgerwizard.Functionality.Static;
import com.burgerwizard.alex.burgerwizard.Functionality.User;

import java.util.ArrayList;

public class ActivityBurgerWizard extends AppCompatActivity {

    private LinearLayout llIngredients;
    private User user;
    private ArrayList<CustomIngredientSelector> customIngredientSelectors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_wizard);

        user = (User) getIntent().getSerializableExtra(Static.USER_EXTRA);
        Toast.makeText(this, "User: "+user.getName(),Toast.LENGTH_SHORT).show();
        llIngredients = findViewById(R.id.activity_burger_wizard_ll_ingredient_list);

        initializeIngredients();
    }

    private void initializeIngredients(){

        CustomIngredientSelector selector1 = new CustomIngredientSelector(this);
        CustomIngredientSelector selector2 = new CustomIngredientSelector(this);
        CustomIngredientSelector selector3 = new CustomIngredientSelector(this);

        customIngredientSelectors = new ArrayList<>();
        customIngredientSelectors.add(selector1);
        customIngredientSelectors.add(selector2);
        customIngredientSelectors.add(selector3);

        Ingredient red = new Ingredient("Red",R.color.red,1.05f);
        Ingredient green = new Ingredient("Green",R.color.green,1.05f);
        Ingredient blue = new Ingredient("Blue",R.color.blue,1.05f);

        selector1.setIngredients(new Ingredient[]{red, green, blue});
        selector2.setIngredients(new Ingredient[]{red, green, blue});
        selector3.setIngredients(new Ingredient[]{red, green, blue});

        llIngredients.addView(selector1);
        llIngredients.addView(selector2);
        llIngredients.addView(selector3);

        findViewById(R.id.activity_burger_wizard_tv_next).setOnClickListener(this::checkOut);

    }

    private void checkOut(View view){

        ArrayList<Ingredient> ingredients = new ArrayList<>();

        for (CustomIngredientSelector selector : customIngredientSelectors){
            ingredients.add(selector.getCurrentIngredient());
        }

        Intent intent = new Intent(this, ActivityCheckOut.class);
        intent.putExtra(Static.USER_EXTRA, user);
        intent.putExtra(Static.INGREDIENT_LIST_EXTRA,ingredients);
        startActivity(intent);

    }
}
