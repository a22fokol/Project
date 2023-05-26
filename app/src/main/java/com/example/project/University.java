package com.example.project;

import java.io.Serializable;
import java.util.List;
import com.example.project.University;



public class University implements Serializable {
    private String id;
    private String name;
    private String login;
    private String company;
    private String location;
    private String category;
    private int size;
    private int cost;
    private String auxData;
    private List<String> imageUrls;


    public University(String id, String name, String login, String company, String location, String category, String sizeStr, String costStr, String auxData, List<String> imageUrls) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.company = company;
        this.location = location;
        this.category = category;
        this.size = Integer.parseInt(sizeStr);
        this.cost = Integer.parseInt(costStr);
        this.auxData = auxData;
        this.imageUrls = imageUrls;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public int getSize() {
        return size;
    }

    public int getCost() {
        return cost;
    }

    public String getAuxData() {
        return auxData;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public List<String> getImageUrls() {
        return imageUrls;
    }
    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setAuxData(String auxData) {
        this.auxData = auxData;
    }
}
