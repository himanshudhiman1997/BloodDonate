package com.himanshu.android.blooddonate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;

public class AccepterDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accepter_details);

        Intent i = getIntent();

        String accepterName = i.getStringExtra("name");
        String accepterAge = i.getStringExtra("age");
        String accepterPhone = i.getStringExtra("phone");
        String accepterAddress = i.getStringExtra("address");
        String accepterGender = i.getStringExtra("gender");


        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView ageTextView = findViewById(R.id.ageTextView);
        TextView phoneTextView = findViewById(R.id.phoneTextView);
        TextView addressTextView = findViewById(R.id.addressTextView);
        TextView genderTextView = findViewById(R.id.genderTextView);

        nameTextView.setText("Name: " + accepterName);
        ageTextView.setText("Age: " + accepterAge);
        phoneTextView.setText("Phone: " + accepterPhone);
        addressTextView.setText("Address: " + accepterAddress);
        genderTextView.setText("Gender: " + accepterGender);

        Button button = findViewById(R.id.checkButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccepterDetailsActivity.this, RequiredBlood.class);
                startActivity(intent);
            }
        });
    }

    public void signout(View v) {
        AuthUI.getInstance().signOut(this);
        Intent intent = new Intent(AccepterDetailsActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
