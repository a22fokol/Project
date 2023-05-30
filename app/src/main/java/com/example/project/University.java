package com.example.project;

import android.os.Parcel;
import android.os.Parcelable;

public class University implements Parcelable {
    private String id;
    private String name;
    private String company;
    private String location;
    private String category;
    private int size;
    private int cost;

    public University(String id, String name, String login, String company, String location, String category, int size, int cost) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.location = location;
        this.category = category;
        this.size = size;
        this.cost = cost;
    }

    // Getters and setters

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }

    public String getCompany() {
        return company;
    }

    public String getId() {
        return id;
    }

    // Parcelable implementation

    protected University(Parcel in) {
        id = in.readString();
        name = in.readString();
        company = in.readString();
        location = in.readString();
        category = in.readString();
        size = in.readInt();
        cost = in.readInt();
    }

    public static final Creator<University> CREATOR = new Creator<University>() {
        @Override
        public University createFromParcel(Parcel in) {
            return new University(in);
        }

        @Override
        public University[] newArray(int size) {
            return new University[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(company);
        dest.writeString(location);
        dest.writeString(category);
        dest.writeInt(size);
        dest.writeInt(cost);
    }
}
