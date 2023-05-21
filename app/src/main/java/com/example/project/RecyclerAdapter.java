package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<Country> universityList;
    private OnItemClickListener listener;

    public RecyclerAdapter(ArrayList<Country> universityList, OnItemClickListener listener) {
        this.universityList = universityList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Country university = universityList.get(position);

        // Set the university name
        holder.universityName.setText(university.getName());

        // Set the university location with population
        String locationWithPopulation = university.getLocation() + " (Population: " + university.getPopulation() + ")";
        holder.universityLocation.setText(locationWithPopulation);

        // Set the university image
        Picasso.get().load(university.getImageUrl()).into(holder.universityImage);
    }


    @Override
    public int getItemCount() {
        return universityList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Country university);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView universityName;
        public TextView universityLocation;
        public TextView universityPopulation;
        public ImageView universityImage;

        public MyViewHolder(View view) {
            super(view);
            universityName = view.findViewById(R.id.UniversityName);
            universityLocation = view.findViewById(R.id.UniversityLocation);
            universityPopulation = view.findViewById(R.id.UniversityPopulation);
            universityImage = view.findViewById(R.id.UniversityImage);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getBindingAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Country university = universityList.get(position);
                listener.onItemClick(university);
            }
        }
    }
}
