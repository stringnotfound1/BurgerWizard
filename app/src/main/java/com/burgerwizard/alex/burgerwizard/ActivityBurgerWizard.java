package com.burgerwizard.alex.burgerwizard;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.burgerwizard.alex.burgerwizard.CustomElements.CustomIngredientSelector;
import com.burgerwizard.alex.burgerwizard.Functionality.Ingredient;
import com.burgerwizard.alex.burgerwizard.Functionality.Static;
import com.burgerwizard.alex.burgerwizard.Functionality.User;

import java.util.ArrayList;

public class ActivityBurgerWizard extends AppCompatActivity {

    private LinearLayout llIngredients;
    private User user;
    private ArrayList<CustomIngredientSelector> customIngredientSelectors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_wizard);

        user = (User) getIntent().getSerializableExtra(Static.USER_EXTRA);
        Toast.makeText(this, "User: "+user.getName(),Toast.LENGTH_SHORT).show();
        llIngredients = findViewById(R.id.activity_burger_wizard_ll_ingredient_list);

        initializeIngredients();
    }

    private void initializeIngredients(){

        CustomIngredientSelector selectorBreadTop = new CustomIngredientSelector(this);
        CustomIngredientSelector selectorMeat = new CustomIngredientSelector(this);
        CustomIngredientSelector selectorSauce = new CustomIngredientSelector(this);
        CustomIngredientSelector selectorExtra1 = new CustomIngredientSelector(this);
        CustomIngredientSelector selectorExtra2 = new CustomIngredientSelector(this);
        CustomIngredientSelector selectorBreadBot = new CustomIngredientSelector(this);

        customIngredientSelectors = new ArrayList<>();
        customIngredientSelectors.add(selectorBreadTop);
        customIngredientSelectors.add(selectorExtra1);
        customIngredientSelectors.add(selectorSauce);
        customIngredientSelectors.add(selectorMeat);
        customIngredientSelectors.add(selectorExtra2);
        customIngredientSelectors.add(selectorBreadBot);

        /* bread start */
        Ingredient brot_top = new Ingredient("Brot", R.drawable.brot_top, 1f);
        Ingredient brot_bot = new Ingredient("Brot", R.drawable.brot_bot, 1f);

        Ingredient brot_top_chi = new Ingredient("Brot Chia", R.drawable.brot_top_chi, 1f);
        Ingredient brot_bot_chi = new Ingredient("Brot Chia", R.drawable.brot_bot_chi, 1f);

        Ingredient brot_top_laugen = new Ingredient("Brot Lauge", R.drawable.brot_top_laugen, 1f);
        Ingredient brot_bot_laugen = new Ingredient("Brot Lauge", R.drawable.brot_bot_laugen, 1f);
        /* bread end */

        /* meat start */
        Ingredient rind = new Ingredient("Rind", R.drawable.fleisch, 1f);
        Ingredient fisch = new Ingredient("Fisch", R.drawable.fisch, 1f);
        Ingredient huhn = new Ingredient("Huhn", R.drawable.huhn, 1f);

        /* extras start */
        Ingredient bacon = new Ingredient("Bacon", R.drawable.bacon, 1f);
        Ingredient kaese = new Ingredient("Käse", R.drawable.kaese, 1f);
        Ingredient salat = new Ingredient("Salat", R.drawable.salat, 1f);
        Ingredient rucola = new Ingredient("Rucola", R.drawable.rucola, 1f);
        Ingredient tomate = new Ingredient("Tomate", R.drawable.tomate, 1f);
        Ingredient gurke = new Ingredient("Gurke", R.drawable.gurke, 1f);
        /* extras end */

        /* sauce start*/
        Ingredient bbq = new Ingredient("BBQ", R.drawable.bbq, 1f);
        Ingredient kaesesauce = new Ingredient("Käsesauce", R.drawable.kaesesau, 1f);
        Ingredient salsa = new Ingredient("Salsa", R.drawable.salsa, 1f);
        Ingredient sauerrahm = new Ingredient("Sauerrahm", R.drawable.sauerrahm, 1f);
        /* sauce end */

        selectorBreadTop.setIngredients(new Ingredient[]{brot_top, brot_top_chi, brot_top_laugen});
        selectorExtra1.setIngredients(new Ingredient[]{bacon, kaese, salat, rucola, tomate, gurke});
        selectorSauce.setIngredients(new Ingredient[]{salsa, bbq, kaesesauce, sauerrahm});
        selectorMeat.setIngredients(new Ingredient[]{rind, huhn, fisch});
        selectorExtra2.setIngredients(new Ingredient[]{bacon, kaese, salat, rucola, tomate, gurke});
        selectorBreadBot.setIngredients(new Ingredient[]{brot_bot, brot_bot_chi, brot_bot_laugen});

        llIngredients.addView(selectorBreadTop);
        llIngredients.addView(selectorExtra1);
        llIngredients.addView(selectorSauce);
        llIngredients.addView(selectorExtra2);
        llIngredients.addView(selectorMeat);
        llIngredients.addView(selectorBreadBot);

        findViewById(R.id.activity_burger_wizard_tv_next).setOnClickListener(this::checkOut);

    }

    private void checkOut(View view){

        ArrayList<Ingredient> ingredients = new ArrayList<>();

        for (CustomIngredientSelector selector : customIngredientSelectors){
            ingredients.add(selector.getCurrentIngredient());
        }

        Intent intent = new Intent(this, ActivityCheckOut.class);
        intent.putExtra(Static.USER_EXTRA, user);
        intent.putExtra(Static.INGREDIENT_LIST_EXTRA,ingredients);
        startActivity(intent);

    }
}
