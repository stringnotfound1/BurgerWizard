package com.burgerwizard.alex.burgerwizard;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.burgerwizard.alex.burgerwizard.CustomElements.CustomIngredientSelector;
import com.burgerwizard.alex.burgerwizard.Functionality.Ingredient;
import com.burgerwizard.alex.burgerwizard.Functionality.Static;
import com.burgerwizard.alex.burgerwizard.Functionality.User;

public class ActivityBurgerWizard extends AppCompatActivity {

    private LinearLayout llIngredients;
    private User user;

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

        Ingredient red = new Ingredient("Red",getDrawable(R.color.red),1.05f);
        Ingredient green = new Ingredient("Green",getDrawable(R.color.green),1.05f);
        Ingredient blue = new Ingredient("Blue",getDrawable(R.color.blue),1.05f);

        selector1.setIngredients(new Ingredient[]{red, green, blue});
        selector2.setIngredients(new Ingredient[]{red, green, blue});
        selector3.setIngredients(new Ingredient[]{red, green, blue});

        llIngredients.addView(selector1);
        llIngredients.addView(selector2);
        llIngredients.addView(selector3);


    }
}
