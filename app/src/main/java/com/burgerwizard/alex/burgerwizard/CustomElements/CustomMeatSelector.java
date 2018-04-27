package com.burgerwizard.alex.burgerwizard.CustomElements;

import android.content.Context;

import com.burgerwizard.alex.burgerwizard.Functionality.Ingredient;
import com.burgerwizard.alex.burgerwizard.Functionality.Static;

/**
 * Created by Alex on 27.04.2018.
 */

public class CustomMeatSelector extends CustomIngredientSelector{
    public CustomMeatSelector(Context context) {
        super(context);
        setIngredients(new Ingredient[]{Static.RIND, Static.HUHN, Static.FISCH});
    }
}
