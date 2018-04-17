package com.burgerwizard.alex.burgerwizard.CustomElements;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.burgerwizard.alex.burgerwizard.Functionality.Ingredient;
import com.burgerwizard.alex.burgerwizard.R;

import java.lang.reflect.Array;

/**
 * Created by Alex on 16.04.2018.
 */

public class CustomIngredientSelector extends LinearLayout{

    private ImageView ivButtonLeft;
    private ImageView ivIngredient;
    private ImageView ivButtonRight;

    private Ingredient[] ingredients;
    private int currentIndex = 0;


    public CustomIngredientSelector(Context context) {
        super(context);
        init();
    }

    public void setIngredientDrawable(Drawable drawable){
        this.ivIngredient.setImageDrawable(drawable);
    }

    public void setIngredients(Ingredient[] ingredients){
        this.ingredients = ingredients;
        setIngredientDrawable(ingredients[0].getDrawable());
    }

    private void init(){
        inflate(getContext(), R.layout.custom_ingredient_selector, this);

        ivButtonLeft = findViewById(R.id.custom_ingredient_selector_arrow_left);
        ivIngredient = findViewById(R.id.custom_ingredient_selector_ingredient);
        ivButtonRight = findViewById(R.id.custom_ingredient_selector_arrow_right);

        ivButtonLeft.setOnClickListener(this::swipeLeft);
        ivButtonRight.setOnClickListener(this::swipeRight);

    }

    private void swipeRight(View view) {
        swipe(1);
    }

    private void swipeLeft(View view) {
        swipe(-1);
    }

    private void swipe(int direction) {

        currentIndex = currentIndex+direction;
        if (currentIndex < 0)
            currentIndex = this.ingredients.length-1;
        if(currentIndex > this.ingredients.length-1)
            currentIndex = 0;
        setIngredientDrawable(this.ingredients[currentIndex].getDrawable());

    }


}
