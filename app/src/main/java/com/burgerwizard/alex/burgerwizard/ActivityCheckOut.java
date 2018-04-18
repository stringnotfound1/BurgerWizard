package com.burgerwizard.alex.burgerwizard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.burgerwizard.alex.burgerwizard.Functionality.Ingredient;
import com.burgerwizard.alex.burgerwizard.Functionality.Static;
import com.burgerwizard.alex.burgerwizard.Functionality.User;

import java.util.ArrayList;

public class ActivityCheckOut extends AppCompatActivity {

    private TextView tvResult;
    private User user;
    private ArrayList<Ingredient> ingredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        tvResult = findViewById(R.id.activity_check_out_tv);

        user = (User) getIntent().getSerializableExtra(Static.USER_EXTRA);
        ingredients = (ArrayList<Ingredient>) getIntent().getSerializableExtra(Static.INGREDIENT_LIST_EXTRA);

        String result = user.toString()+"\n"+ingredients.toString();
        tvResult.setText(result);
    }
}
