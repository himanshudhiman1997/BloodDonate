package com.himanshu.android.blooddonate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class  RequiredBlood extends AppCompatActivity {

    DatabaseReference databaseReferenceDonors;
    List<Donor> donorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_required_blood);

        databaseReferenceDonors = FirebaseDatabase.getInstance().getReference("donors");

        donorList = new ArrayList<>();


    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReferenceDonors.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                donorList.clear();
                for (DataSnapshot donorSnapshot : dataSnapshot.getChildren()) {
                    Donor donor = donorSnapshot.getValue(Donor.class);
                    donorList.add(donor);
                }

                DonorList adapter = new DonorList(RequiredBlood.this, donorList);
                ListView listViewDonors = findViewById(R.id.listViewDonors);
                listViewDonors.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
