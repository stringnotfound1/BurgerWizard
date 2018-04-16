package com.burgerwizard.alex.burgerwizard;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.burgerwizard.alex.burgerwizard.CustomElements.CustomIngredientSelector;

public class ActivityBurgerWizard extends AppCompatActivity {

    private LinearLayout llIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_wizard);
        llIngredients = findViewById(R.id.activity_burger_wizard_ll_ingredient_list);



        initializeIngredients();
    }

    private void initializeIngredients(){

        CustomIngredientSelector selector1 = new CustomIngredientSelector(this);
        CustomIngredientSelector selector2 = new CustomIngredientSelector(this);
        CustomIngredientSelector selector3 = new CustomIngredientSelector(this);

        selector1.setIngredients(new Drawable[]{getDrawable(R.color.colorAccent), getDrawable(R.color.colorPrimary), getDrawable(R.color.colorPrimaryDark)});
        selector2.setIngredients(new Drawable[]{getDrawable(R.color.red), getDrawable(R.color.green), getDrawable(R.color.blue)});
        selector3.setIngredients(new Drawable[]{getDrawable(R.color.colorAccent), getDrawable(R.color.colorPrimary), getDrawable(R.color.colorPrimaryDark)});

        llIngredients.addView(selector1);
        llIngredients.addView(selector2);
        llIngredients.addView(selector3);


    }
}
