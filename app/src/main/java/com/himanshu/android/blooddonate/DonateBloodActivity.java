package com.himanshu.android.blooddonate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DonateBloodActivity extends AppCompatActivity {
    EditText donorNameEdit;
    EditText donorAgeEdit;
    EditText donorPhoneEdit;
    EditText donorAddressEdit;
    RadioButton maleRadioButton;
    RadioButton femaleRadioButton;
    RadioButton aPosRadioButton;
    RadioButton aNegRadioButton;
    RadioButton abPosRadioButton;
    RadioButton abNegRadioButton;
    RadioButton bPosRadioButton;
    RadioButton bNegRadioButton;
    RadioButton oPosRadioButton;
    RadioButton oNegRadioButton;
    String gender = "";
    String bloodGroup = "";
    Button submitButton;

    DatabaseReference databaseDonor;
    String donorName;
    String donorAge;
    String donorPhone;
    String donorAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_blood);

        databaseDonor = FirebaseDatabase.getInstance().getReference("donors");

        donorNameEdit = findViewById(R.id.donorName);
        donorAgeEdit = findViewById(R.id.donorAge);
        donorPhoneEdit = findViewById(R.id.donorPhone);
        donorAddressEdit = findViewById(R.id.donorAddress);

        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);

        aPosRadioButton = findViewById(R.id.aPosRadioButton);
        aNegRadioButton = findViewById(R.id.aNegRadioButton);
        bPosRadioButton = findViewById(R.id.bPosRadioButton);
        bNegRadioButton = findViewById(R.id.bNegRadioButton);
        abPosRadioButton = findViewById(R.id.abPosRadioButton);
        abNegRadioButton = findViewById(R.id.abNegRadioButton);
        oPosRadioButton = findViewById(R.id.oPosRadioButton);
        oNegRadioButton = findViewById(R.id.oNegRadioButton);


        submitButton = findViewById(R.id.submitButton);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donorName = donorNameEdit.getText().toString().trim();
                donorAge = donorAgeEdit.getText().toString();
                donorPhone = donorPhoneEdit.getText().toString().trim();
                donorAddress = donorAddressEdit.getText().toString().trim();

                int age = Integer.getInteger(donorAge);


                if (maleRadioButton.isChecked()) {
                    gender = "Male";
                } else if (femaleRadioButton.isChecked()) {
                    gender = "Female";
                }
                if (aPosRadioButton.isChecked()) {
                    bloodGroup = "A+";
                } else if (aNegRadioButton.isChecked()) {
                    bloodGroup = "A-";
                } else if (bPosRadioButton.isChecked()) {
                    bloodGroup = "B+";
                } else if (bNegRadioButton.isChecked()) {
                    bloodGroup = "B-";
                } else if (abPosRadioButton.isChecked()) {
                    bloodGroup = "AB+";
                } else if (abNegRadioButton.isChecked()) {
                    bloodGroup = "AB-";
                } else if (oPosRadioButton.isChecked()) {
                    bloodGroup = "O+";
                } else if (oNegRadioButton.isChecked()) {
                    bloodGroup = "O-";
                }
                if (donorName == null || donorPhone == null || donorAddress == null || donorAge == null || gender.equals("") || bloodGroup.equals("")) {
                    Toast.makeText(DonateBloodActivity.this, "Enter all the details", Toast.LENGTH_LONG).show();
                }
                else if(donorPhone.length() != 10)
                {
                    Toast.makeText(DonateBloodActivity.this, "Enter the correct phone number", Toast.LENGTH_LONG).show();
                }

                else if(age < 17)
                {
                    Toast.makeText(DonateBloodActivity.this, "Your age does not allow you to donate blood", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(DonateBloodActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    addDonor();

                    donorNameEdit.setText("");
                    donorAgeEdit.setText("");
                    donorAddressEdit.setText("");
                    donorPhoneEdit.setText("");
                    maleRadioButton.setChecked(false);
                    femaleRadioButton.setChecked(false);
                    aPosRadioButton.setChecked(false);
                    aNegRadioButton.setChecked(false);
                    bPosRadioButton.setChecked(false);
                    bNegRadioButton.setChecked(false);
                    abPosRadioButton.setChecked(false);
                    abNegRadioButton.setChecked(false);
                    oPosRadioButton.setChecked(false);
                    oNegRadioButton.setChecked(false);
                }
            }
        });


    }

    private void addDonor() {

        String id = databaseDonor.push().getKey();

        Donor donor = new Donor(id, donorName, donorAge, gender, donorPhone, donorAddress, bloodGroup);
        databaseDonor.child(id).setValue(donor);

        Toast.makeText(this, "Donor added", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(DonateBloodActivity.this, DonorDetailsActivity.class);

        intent.putExtra("name", donorName);
        intent.putExtra("age", donorAge);
        intent.putExtra("address", donorAddress);
        intent.putExtra("gender", gender);
        intent.putExtra("bloodGroup", bloodGroup);
        intent.putExtra("phone", donorPhone);

        startActivity(intent);

    }

}
