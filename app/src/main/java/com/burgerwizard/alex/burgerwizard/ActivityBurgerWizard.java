package com.burgerwizard.alex.burgerwizard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.burgerwizard.alex.burgerwizard.CustomElements.CustomBreadBotSelector;
import com.burgerwizard.alex.burgerwizard.CustomElements.CustomBreadTopSelector;
import com.burgerwizard.alex.burgerwizard.CustomElements.CustomExtraSelector;
import com.burgerwizard.alex.burgerwizard.CustomElements.CustomIngredientSelector;
import com.burgerwizard.alex.burgerwizard.CustomElements.CustomMeatSelector;
import com.burgerwizard.alex.burgerwizard.CustomElements.CustomSauceSelector;
import com.burgerwizard.alex.burgerwizard.Functionality.Ingredient;
import com.burgerwizard.alex.burgerwizard.Functionality.Static;
import com.burgerwizard.alex.burgerwizard.Functionality.User;
import com.jmedeisis.draglinearlayout.DragLinearLayout;

import java.util.ArrayList;

/**
 * The Burgerwizard
 */
public class ActivityBurgerWizard extends AppCompatActivity {

    private DragLinearLayout llIngredients;
    private User user;
    private ArrayList<CustomIngredientSelector> customIngredientSelectors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_wizard);

        user = (User) getIntent().getSerializableExtra(Static.USER_EXTRA);
        Toast.makeText(this, "User: " + user.getName(), Toast.LENGTH_SHORT).show();
        llIngredients = findViewById(R.id.activity_burger_wizard_ll_ingredient_list);

        TextView tvAddExtra = findViewById(R.id.activity_burger_wizard_tv_extra);
        TextView tvAddMeat = findViewById(R.id.activity_burger_wizard_tv_meat);
        TextView tvAddSauce = findViewById(R.id.activity_burger_wizard_tv_sauce);

        tvAddExtra.setOnClickListener((View view) -> {
            llIngredients.addView(new CustomExtraSelector(this), llIngredients.getChildCount() - 1);
            updateDragAndDrop();
        });
        tvAddMeat.setOnClickListener((View view) -> {
            llIngredients.addView(new CustomMeatSelector(this), llIngredients.getChildCount() - 1);
            updateDragAndDrop();
        });
        tvAddSauce.setOnClickListener((View view) -> {
            llIngredients.addView(new CustomSauceSelector(this), llIngredients.getChildCount() - 1);
            updateDragAndDrop();
        });

        initializeIngredients();
    }

    /**
     * adds a default list of ingredients to the burger: Top Bun, Extra, Sauce, Extra, Meat and Bottom Bun
     */
    private void initializeIngredients() {

        customIngredientSelectors = new ArrayList<>();

        llIngredients.addView(new CustomBreadTopSelector(this));
        llIngredients.addView(new CustomExtraSelector(this));
        llIngredients.addView(new CustomSauceSelector(this));
        llIngredients.addView(new CustomExtraSelector(this));
        llIngredients.addView(new CustomMeatSelector(this));
        llIngredients.addView(new CustomBreadBotSelector(this));

        findViewById(R.id.activity_burger_wizard_tv_next).setOnClickListener(this::checkOut);

        updateDragAndDrop();
    }

    /**
     * Gathers all used ingredients and starts {@link com.burgerwizard.alex.burgerwizard.ActivityCheckOut} with an {@link com.burgerwizard.alex.burgerwizard.Functionality.Ingredient} list as extra
     *
     * @param view only used due to lambda usage
     */
    private void checkOut(View view) {

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        customIngredientSelectors = new ArrayList<>();

        for (int i = 0; i < llIngredients.getChildCount(); i++) {
            CustomIngredientSelector customIngredientSelector;
            if (llIngredients.getChildAt(i) instanceof CustomIngredientSelector) {
                customIngredientSelector = (CustomIngredientSelector) llIngredients.getChildAt(i);
                customIngredientSelectors.add(customIngredientSelector);
            }
        }

        for (CustomIngredientSelector selector : customIngredientSelectors) {
            ingredients.add(selector.getCurrentIngredient());
        }

        Intent intent = new Intent(this, ActivityCheckOut.class);
        intent.putExtra(Static.USER_EXTRA, user);
        intent.putExtra(Static.INGREDIENT_LIST_EXTRA, ingredients);
        startActivity(intent);

    }

    /**
     * Needs to be called after adding a new view to the DragLinearLayout, see https://github.com/justasm/DragLinearLayout "Enabling drag & swap for all child views"
     */
    private void updateDragAndDrop() {

        // https://github.com/justasm/DragLinearLayout siehe "Enabling drag & swap for all child views"
        for (int i = 1; i < llIngredients.getChildCount() - 1; i++) {
            View child = llIngredients.getChildAt(i);
            llIngredients.setViewDraggable(child, child); // the child is its own drag handle
        }
    }
}
