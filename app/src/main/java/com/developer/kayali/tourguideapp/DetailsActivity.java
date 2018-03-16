package com.developer.kayali.tourguideapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        // Initialize the Views
        ImageView imageView = findViewById(R.id.image_details);
        TextView name = findViewById(R.id.event_name_details);
        TextView address = findViewById(R.id.event_address_details);
        TextView description = findViewById(R.id.event_description_details);
        // Bundle to retrieve Event's Information from the Fragment
        Bundle extras = getIntent().getExtras();
        // Set the Event Information to the Views
        if (extras != null) {
            imageView.setImageResource(extras.getInt("eventImageID"));
            name.setText(extras.getString("eventName"));
            address.setText(extras.getString("eventAddress"));
            description.setText(extras.getString("eventDescription"));
        } else {
            // When retrieving the extras from Intent failed
            Toast.makeText(this,R.string.errorMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
