package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        /// Created and populate the university list
        ArrayList<Country> universityList = new ArrayList<>();

        universityList.add(new Country("University of Umeå (Swedeen)", "Umeå", 132235,
                "University of Umeå is a state university located in Umeå,county of Västerbotten , founded in 1965",
                "https://www.umu.se/globalassets/qbank/arkitekthogskolan_8848_170808_ubs-10897crop016254723078resize1280720autoorientquality90density150stripextensionjpgid16.jpg?format=webp&mode=crop&width=1280",
                "https://mobprog.webug.se/json-api?login=a22fokol"));

        universityList.add(new Country("University of Helsinki (Finland)", "Helsinki", 1338000,
                "University of Helsinki is the main and oldest university in Finland,locate in southern finland the capital Helsinki.",
                "https://thumbs.dreamstime.com/z/main-building-university-helsinki-finland-34277733.jpg",
                "https://mobprog.webug.se/json-api?login=a22fokol"));

        universityList.add(new Country("University of Oslo (Norway)", "Olso", 1086000,
                "University of Oslo is the oldest and largest institution of higher education in Norway",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/The_University_of_Oslo.jpg/1024px-The_University_of_Oslo.jpg",
                "https://mobprog.webug.se/json-api?login=a22fokol"));

        universityList.add(new Country("University of Copenhagen (Danemark)", "Copenhagen",
                1381000, "University of Copenhagen is Denmark's oldest and largest educational and research institution.",
                "https://uniavisen.dk/wp-content/uploads/2018/02/landbohoejskolen2.jpg",
                "https://mobprog.webug.se/json-api?login=a22fokol"));

        // Create an instance of the RecyclerAdapter with the university list and listener
        adapter = new RecyclerAdapter(universityList, this);

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(adapter);

        // Set the layout manager and item animator for the RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.aboutButton) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(Country university) {
        // Handle item click
        Intent intent = new Intent(MainActivity.this, UniversityDetailsActivity.class);
        intent.putExtra("university", university);
        startActivity(intent);
    }
}
