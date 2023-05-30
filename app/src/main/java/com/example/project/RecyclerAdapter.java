package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<University> universityList;
    private OnItemClickListener listener;

    public RecyclerAdapter(ArrayList<University> universityList, OnItemClickListener listener) {
        this.universityList = universityList;
        this.listener = listener;
    }

    public void updateUniversityList(ArrayList<University> newUniversityList) {
        universityList.clear();
        universityList.addAll(newUniversityList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        University university = universityList.get(position);

        // Set the university name
        holder.universityName.setText(university.getName());

        // Set the university location
        holder.universityLocation.setText(university.getLocation());

        // Set the university size
        holder.universitySize.setText(String.valueOf(university.getSize()));

        // Set the university cost
        holder.universityCost.setText(String.valueOf(university.getCost()));

        // Set the university category
        holder.universityCategory.setText(university.getCategory());

        // Set the university ID
        holder.universityId.setText(university.getId());


        // Set the university cateegory
        holder.universityCompany.setText(university.getCompany());
    }

    @Override
    public int getItemCount() {
        return universityList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(University university);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView universityName;
        public TextView universityLocation;
        public TextView universitySize;
        public TextView universityCost;
        public TextView universityCategory;
        public TextView universityId;
        public TextView universityCompany;

        public MyViewHolder(View view) {
            super(view);
            universityName = view.findViewById(R.id.UniversityName);
            universityLocation = view.findViewById(R.id.UniversityLocation);
            universitySize = view.findViewById(R.id.UniversitySize);
            universityCost = view.findViewById(R.id.UniversityCost);
            universityCategory = view.findViewById(R.id.UniversityCategory);
            universityId = view.findViewById(R.id.UniversityId);
            universityCompany = view.findViewById(R.id.UniversityCompany);

            view.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int position = getBindingAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                University university = universityList.get(position);
                listener.onItemClick(university);
            }
        }
    }



}
