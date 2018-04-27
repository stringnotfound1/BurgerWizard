package com.burgerwizard.alex.burgerwizard.CustomElements;

import android.content.Context;

import com.burgerwizard.alex.burgerwizard.Functionality.Ingredient;
import com.burgerwizard.alex.burgerwizard.Functionality.Static;

/**
 * Created by Alex on 27.04.2018.
 */

public class CustomBreadBotSelector extends CustomIngredientSelector {
    public CustomBreadBotSelector(Context context) {
        super(context);
        setIngredients(new Ingredient[]{Static.BROT_BOT, Static.BROT_BOT_CHI, Static.BROT_BOT_LAUGEN});
    }
}
