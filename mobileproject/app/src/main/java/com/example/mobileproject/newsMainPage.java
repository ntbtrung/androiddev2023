package com.example.mobileproject;

import java.util.ArrayList;

public class newsMainPage {

    private String status;
    private String totalResults;
    private ArrayList<newsModelClass> articles;

    public newsMainPage(String status, String totalResults, ArrayList<newsModelClass> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<newsModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<newsModelClass> articles) {
        this.articles = articles;
    }
}

