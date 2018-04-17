package com.burgerwizard.alex.burgerwizard.Functionality;

import android.graphics.drawable.Drawable;

import lombok.Data;

/**
 * Created by Alex on 17.04.2018.
 */

@Data
public class Ingredient {

    private String identifier;
    private Drawable drawable;
    private float price;

    public Ingredient(String identifier, Drawable drawable, float price) {
        this.identifier = identifier;
        this.drawable = drawable;
        this.price = price;
    }
}
