package com.example.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.University;

public class UniversityDetailsActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewLocation;
    private TextView textViewSize;
    private TextView textViewCost;
    private TextView textViewCategory;
    private TextView textViewCompany;
    private TextView textViewId; // Declare textViewId

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_details);

        textViewName = findViewById(R.id.textViewName);
        textViewLocation = findViewById(R.id.textViewLocation);
        textViewSize = findViewById(R.id.textViewSize);
        textViewCost = findViewById(R.id.textViewCost);
        textViewCategory = findViewById(R.id.textViewCategory);
        textViewCompany = findViewById(R.id.textViewCompany);
        textViewId = findViewById(R.id.textViewId); // Initialize textViewId

        University university = getIntent().getParcelableExtra("university");
        if (university != null) {
            textViewName.setText("Name:"+university.getName());
            textViewLocation.setText("Location: " +university.getLocation());
            textViewSize.setText("Size: " + university.getSize());
            textViewCost.setText("Cost: " + university.getCost());
            textViewCategory.setText("Category: " + university.getCategory());
            textViewCompany.setText("Company: " + university.getCompany());
            textViewId.setText("ID: " + university.getId()); // Set the text for textViewId
        } else {
            // Handle the case where the University object is null
            // You can display an error message or take appropriate action
        }
    }
}
