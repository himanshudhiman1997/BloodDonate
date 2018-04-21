package com.himanshu.android.blooddonate;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class DonorList extends ArrayAdapter<Donor> {

    private Activity context;
    private List<Donor> donorList;


    public DonorList(Activity context, List<Donor> donorList) {
        super(context, R.layout.list_layout, donorList);
        this.context = context;
        this.donorList = donorList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = context.getLayoutInflater();

        View listViewItem = layoutInflater.inflate(R.layout.list_layout, null, true);

        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewPhone = listViewItem.findViewById(R.id.textViewPhone);
        TextView textViewAge = listViewItem.findViewById(R.id.textViewAge);
        TextView textViewGender = listViewItem.findViewById(R.id.textViewGender);
        TextView textViewBlood = listViewItem.findViewById(R.id.textViewBlood);
        TextView textViewAddress = listViewItem.findViewById(R.id.textViewAddress);

        final Donor donor = donorList.get(position);

        final String phone = donor.getDonorPhone();
        textViewName.setText("Name: " + donor.getDonorName());
        textViewPhone.setText(donor.getDonorPhone());
        textViewAge.setText("Age: " + donor.getDonorAge());
        textViewGender.setText("Gender: " + donor.getDonorGender());
        textViewBlood.setText("Blood Group: " + donor.getDonorBloodGroup());
        textViewAddress.setText("Address: " + donor.getDonorAddress());

        Button buttonCall = listViewItem.findViewById(R.id.buttonCall);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));

                context.startActivity(intent);

            }
        });

        Button buttonLocation = listViewItem.findViewById(R.id.buttonLocate);
        buttonLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.google.com/maps/place/" + donor.getDonorAddress();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);
            }
        });


        return listViewItem;
    }
}
