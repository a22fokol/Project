package com.example.project;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Create an empty university list
        ArrayList<University> universityList = new ArrayList<>();

        // Create an instance of the RecyclerAdapter with the empty university list and listener
        adapter = new RecyclerAdapter(universityList, this);

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(adapter);

        // Set the layout manager and item animator for the RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Fetch university data from the URL
        FetchUniversityDataTask task = new FetchUniversityDataTask();
        task.execute("https://mobprog.webug.se/json-api?login=a22fokol");
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
    public void onItemClick(University university) {
        // Create an intent to start the UniversityDetailsActivity
        Intent intent = new Intent(MainActivity.this, UniversityDetailsActivity.class);
        intent.putExtra("university", university);
        startActivity(intent);
    }

    private class FetchUniversityDataTask extends AsyncTask<String, Void, ArrayList<University>> {
        @Override
        protected ArrayList<University> doInBackground(String... urls) {
            ArrayList<University> universityList = new ArrayList<>();

            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                inputStream.close();

                JSONArray jsonArray = new JSONArray(stringBuilder.toString());

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    String id = jsonObject.getString("ID");
                    String name = jsonObject.getString("name");
                    String login = jsonObject.getString("type");
                    String company = jsonObject.getString("company");
                    String location = jsonObject.getString("location");
                    String category = jsonObject.getString("category");
                    int size = jsonObject.getInt("size");
                    int cost = jsonObject.getInt("cost");
                    String auxData = jsonObject.getString("auxdata");

                    University university = new University(id, name, login, company, location, category,
                            String.valueOf(size), String.valueOf(cost), auxData, new ArrayList<>());
                    universityList.add(university);
                }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            return universityList;
        }

        @Override
        protected void onPostExecute(ArrayList<University> universityList) {
            // Update the university list in the adapter
            adapter.updateUniversityList(universityList);
        }
    }
}
