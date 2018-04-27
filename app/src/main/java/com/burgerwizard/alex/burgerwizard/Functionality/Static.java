package com.burgerwizard.alex.burgerwizard.Functionality;

import com.burgerwizard.alex.burgerwizard.R;

/**
 * Created by Alex on 18.04.2018.
 */

public class Static {

    public static final String USER_EXTRA = "USER_EXTRA";
    public static final String INGREDIENT_LIST_EXTRA = "INGREDIENT_LIST_EXTRA";

    /* Ingredients */
     /* bread start */
    public static final Ingredient BROT_TOP = new Ingredient("Brot", R.drawable.brot_top, 1f);
    public static final Ingredient BROT_BOT = new Ingredient("Brot", R.drawable.brot_bot, 1f);

    public static final Ingredient BROT_TOP_CHI = new Ingredient("Brot Chia", R.drawable.brot_top_chi, 1.5f);
    public static final Ingredient BROT_BOT_CHI = new Ingredient("Brot Chia", R.drawable.brot_bot_chi, 1.5f);

    public static final Ingredient BROT_TOP_LAUGEN = new Ingredient("Brot Lauge", R.drawable.brot_top_laugen, 1.5f);
    public static final Ingredient BROT_BOT_LAUGEN = new Ingredient("Brot Lauge", R.drawable.brot_bot_laugen, 1.5f);
    /* bread end */

    /* meat start */
    public static final Ingredient RIND = new Ingredient("Rind", R.drawable.fleisch, 2.5f);
    public static final Ingredient FISCH = new Ingredient("Fisch", R.drawable.fisch, 3f);
    public static final Ingredient HUHN = new Ingredient("Huhn", R.drawable.huhn, 2f);

    /* extras start */
    public static final Ingredient BACON = new Ingredient("Bacon", R.drawable.bacon, 1.5f);
    public static final Ingredient KAESE = new Ingredient("Käse", R.drawable.kaese, 1f);
    public static final Ingredient SALAT = new Ingredient("Salat", R.drawable.salat, 0.5f);
    public static final Ingredient RUCOLA = new Ingredient("Rucola", R.drawable.rucola, 0.5f);
    public static final Ingredient TOMATE = new Ingredient("Tomate", R.drawable.tomate, 1f);
    public static final Ingredient GURKE = new Ingredient("Gurke", R.drawable.gurke, 1f);
    /* extras end */

    /* sauce start*/
    public static final Ingredient BBQ = new Ingredient("BBQ", R.drawable.bbq, 0.7f);
    public static final Ingredient KAESESAUCE = new Ingredient("Käsesauce", R.drawable.kaesesau, 0.8f);
    public static final Ingredient SALSA = new Ingredient("Salsa", R.drawable.salsa, 0.7f);
    public static final Ingredient SAUERRAHM = new Ingredient("Sauerrahm", R.drawable.sauerrahm, 0.5f);
    /* sauce end */
}
