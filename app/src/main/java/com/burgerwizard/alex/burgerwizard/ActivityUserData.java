package com.burgerwizard.alex.burgerwizard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.burgerwizard.alex.burgerwizard.Functionality.Static;
import com.burgerwizard.alex.burgerwizard.Functionality.User;

public class ActivityUserData extends AppCompatActivity {

    private TextView tvName;
    private TextView tvAddress;
    private TextView tvCCN;
    private TextView tvTelNr;

    private TextView tvNext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        tvName = findViewById(R.id.activity_user_data_tv_name);
        tvAddress = findViewById(R.id.activity_user_data_tv_address);
        tvCCN = findViewById(R.id.activity_user_data_tv_ccn);
        tvTelNr = findViewById(R.id.activity_user_data_tv_telnr);
        tvNext = findViewById(R.id.activity_user_data_tv_next);

        tvNext.setOnClickListener((View view)-> {
            Intent intent = new Intent(this, ActivityBurgerWizard.class);
            User user =  new User(tvName.getText().toString(),tvAddress.getText().toString(), tvCCN.getText().toString(),tvTelNr.getText().toString());
            intent.putExtra(Static.USER_EXTRA,user);
            startActivity(intent);
        });

    }
}
