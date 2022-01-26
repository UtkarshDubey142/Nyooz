package com.utkarsh.nyooz;

import java.util.ArrayList;

public class NewsModal {

    private int totalResults;
    private String status;
    private ArrayList<Articels> articels;

    public NewsModal(int totalResults, String status, ArrayList<Articels> articels) {
        this.totalResults = totalResults;
        this.status = status;
        this.articels = articels;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Articels> getArticels() {
        return articels;
    }

    public void setArticels(ArrayList<Articels> articels) {
        this.articels = articels;
    }
}
