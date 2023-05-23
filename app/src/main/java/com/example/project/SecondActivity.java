package com.example.project;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SecondActivity extends AppCompatActivity {
    TextView secondTextView;
    TextView nameView; // Declared a single variable for TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        secondTextView = findViewById(R.id.secondTextView);
        secondTextView.setText(getString(R.string.about_text));

        if (extras != null) {
            String name = extras.getString("name");

            // Do something with the name

            nameView = findViewById(R.id.UniversityName); // Initialize the variable
            nameView.setText(name);
        }
    }
}
