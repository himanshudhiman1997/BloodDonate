package com.himanshu.android.blooddonate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;


public class DonorDetailsActivity extends AppCompatActivity {


    public String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_details);

        Intent i = getIntent();

        String donorName = i.getStringExtra("name");
        String donorAge = i.getStringExtra("age");
        String donorPhone = i.getStringExtra("phone");
        String donorAddress = i.getStringExtra("address");
        String donorGender = i.getStringExtra("gender");
        String donorBloodGroup = i.getStringExtra("bloodGroup");

        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView ageTextView = findViewById(R.id.ageTextView);
        TextView phoneTextView = findViewById(R.id.phoneTextView);
        TextView addressTextView = findViewById(R.id.addressTextView);
        TextView genderTextView = findViewById(R.id.genderTextView);
        TextView bloodTextView = findViewById(R.id.bloodTextView);

        nameTextView.setText("Name: " + donorName);
        ageTextView.setText("Age: " + donorAge);
        phoneTextView.setText("Phone: " + donorPhone);
        addressTextView.setText("Address: " + donorAddress);
        genderTextView.setText("Gender: " + donorGender);
        bloodTextView.setText("Blood Group: " + donorBloodGroup);

    }

    public void needBlood(View v) {
        Intent intent = new Intent(DonorDetailsActivity.this, NeedBloodActivity.class);
        startActivity(intent);
    }

    public void signOut(View v) {
        AuthUI.getInstance().signOut(this);
        Intent intent = new Intent(DonorDetailsActivity.this, MainActivity.class);
        startActivity(intent);

    }

}
