package com.himanshu.android.blooddonate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DonorTerms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_terms);

    }

    public void accept(View v) {
        Intent intent = new Intent(DonorTerms.this, DonateBloodActivity.class);
        startActivity(intent);
    }

    public void cancel(View v) {
        Intent intent = new Intent(DonorTerms.this, MainActivity.class);
        startActivity(intent);
    }

}
