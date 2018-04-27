package com.burgerwizard.alex.burgerwizard.CustomElements;

import android.content.Context;

import com.burgerwizard.alex.burgerwizard.Functionality.Ingredient;
import com.burgerwizard.alex.burgerwizard.Functionality.Static;

/**
 * Created by Alex on 27.04.2018.
 */

public class CustomBreadTopSelector extends CustomIngredientSelector {

    public CustomBreadTopSelector(Context context) {
        super(context);
        setIngredients(new Ingredient[]{Static.BROT_TOP, Static.BROT_TOP_CHI, Static.BROT_TOP_LAUGEN});
    }
}
