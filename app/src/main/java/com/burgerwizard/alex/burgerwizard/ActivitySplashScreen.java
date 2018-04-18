package com.burgerwizard.alex.burgerwizard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivitySplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.SplashTheme);
//        setContentView(R.layout.activity_splash_screen);
        startActivity(new Intent(this, ActivityUserData.class));

        finish();

    }
}
