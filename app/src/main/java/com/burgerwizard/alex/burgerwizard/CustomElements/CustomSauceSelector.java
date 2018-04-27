package com.burgerwizard.alex.burgerwizard.CustomElements;

import android.content.Context;

import com.burgerwizard.alex.burgerwizard.Functionality.Ingredient;
import com.burgerwizard.alex.burgerwizard.Functionality.Static;

/**
 * Created by Alex on 27.04.2018.
 */

public class CustomSauceSelector extends CustomIngredientSelector{
    public CustomSauceSelector(Context context) {
        super(context);
        setIngredients(new Ingredient[]{Static.SALSA, Static.SAUERRAHM, Static.BBQ, Static.KAESESAUCE});
    }
}
