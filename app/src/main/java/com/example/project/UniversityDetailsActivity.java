package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
public class UniversityDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_details);

        // Retrieved the university object from the intent
        Intent intent = getIntent();
        Country university = (Country) intent.getSerializableExtra("university");

        // Use the university object to populate the details in the activity
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView locationTextView = findViewById(R.id.locationTextView);
        TextView populationTextView = findViewById(R.id.populationTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        ImageView imageView = findViewById(R.id.imageView);
        TextView websiteTextView = findViewById(R.id.websiteTextView); // Add the website TextView in the layout

        nameTextView.setText(university.getName());
        locationTextView.setText(university.getLocation());
        populationTextView.setText(String.valueOf(university.getPopulation()));
        descriptionTextView.setText(university.getDescription());
        websiteTextView.setText(university.getWebsite()); // Set the website TextView with the retrieved website

        // Load the image using a library like Picasso or Glide
        Picasso.get().load(university.getImageUrl()).into(imageView);
    }
}
