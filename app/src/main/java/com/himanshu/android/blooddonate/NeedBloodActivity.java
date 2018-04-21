package com.himanshu.android.blooddonate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class NeedBloodActivity extends AppCompatActivity {

    EditText accepterNameEdit;
    EditText accepterAgeEdit;
    EditText accepterPhoneEdit;
    EditText accepterAddressEdit;
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

    DatabaseReference databaseAccepter;
    String accepterName;
    String accepterAge;
    String accepterPhone;
    String accepterAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_blood);

        databaseAccepter = FirebaseDatabase.getInstance().getReference("accepters");

        accepterNameEdit = findViewById(R.id.accepterName);
        accepterAgeEdit = findViewById(R.id.accepterAge);
        accepterPhoneEdit = findViewById(R.id.accepterPhone);
        accepterAddressEdit = findViewById(R.id.accepterAddress);

        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);

        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accepterName = accepterNameEdit.getText().toString().trim();
                accepterAge = accepterAgeEdit.getText().toString();
                accepterPhone = accepterPhoneEdit.getText().toString().trim();
                accepterAddress = accepterAddressEdit.getText().toString().trim();

                if (maleRadioButton.isChecked()) {
                    gender = "Male";
                } else if (femaleRadioButton.isChecked()) {
                    gender = "Female";
                }

                if (accepterName == null || accepterPhone == null || accepterAddress == null || accepterAge == null || gender.equals("")) {
                    Toast.makeText(NeedBloodActivity.this, "Enter all the details", Toast.LENGTH_SHORT).show();
                } else {
                    addAccepter();

                    accepterNameEdit.setText("");
                    accepterAgeEdit.setText("");
                    accepterAddressEdit.setText("");
                    accepterPhoneEdit.setText("");
                    maleRadioButton.setChecked(false);
                    femaleRadioButton.setChecked(false);

                }
            }
        });


    }

    private void addAccepter() {

        String id = databaseAccepter.push().getKey();

        Accepter accepter = new Accepter(id, accepterName, accepterAge, gender, accepterPhone, accepterAddress);
        databaseAccepter.child(id).setValue(accepter);

        Toast.makeText(this, "Accepter added", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(NeedBloodActivity.this, AccepterDetailsActivity.class);

        intent.putExtra("name", accepterName);
        intent.putExtra("age", accepterAge);
        intent.putExtra("address", accepterAddress);
        intent.putExtra("gender", gender);

        intent.putExtra("phone", accepterPhone);

        startActivity(intent);

    }


}
