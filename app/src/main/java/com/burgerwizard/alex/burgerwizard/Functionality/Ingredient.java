package com.burgerwizard.alex.burgerwizard.Functionality;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by Alex on 17.04.2018.
 */

@Data
public class Ingredient implements Serializable{

    private String identifier;
    private int drawableIndentfier;
    private float price;

    public Ingredient(String identifier, int drawableIndentfier, float price) {
        this.identifier = identifier;
        this.drawableIndentfier = drawableIndentfier;
        this.price = price;
    }
}
