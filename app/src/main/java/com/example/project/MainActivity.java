package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<University> universityList;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        universityList = new ArrayList<>();
        adapter = new RecyclerAdapter(universityList, this);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        requestQueue = Volley.newRequestQueue(this);

        fetchUniversityData();
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
        Intent intent = new Intent(MainActivity.this, UniversityDetailsActivity.class);
        intent.putExtra("university", university);
        startActivity(intent);
    }

    private void fetchUniversityData() {
        String url = "https://mobprog.webug.se/json-api?login=a22fokol";

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<University> universityList = parseJson(response);
                        adapter.updateUniversityList(universityList);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );

        requestQueue.add(request);
    }

    private ArrayList<University> parseJson(JSONArray jsonArray) {
        ArrayList<University> universityList = new ArrayList<>();

        try {
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            String id = jsonObject.getString("ID");
            String name = jsonObject.getString("name");
            String company = jsonObject.getString("company");
            String location = jsonObject.getString("location");
            String category = jsonObject.getString("category");
            int size = jsonObject.getInt("size");
            int cost = jsonObject.getInt("cost");

            University university = new University(id, name, "", company, location, category, size, cost);
            universityList.add(university);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return universityList;
    }
}
