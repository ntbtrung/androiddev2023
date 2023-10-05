package com.example.mobileproject;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NasaItem extends imagesItemsData {
    @SerializedName("data")
    private List<imagesItemsData> data;

    @SerializedName("links") // Include the "links" element
    private List<imagesItemsLinks> links;

    public List<imagesItemsData> getData() {
        return data;
    }

    public List<imagesItemsLinks> getLinks() {
        return links;
    }
}
