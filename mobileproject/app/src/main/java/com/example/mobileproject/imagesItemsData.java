package com.example.mobileproject;

import com.google.gson.annotations.SerializedName;

public class imagesItemsData {
    @SerializedName("center")
    private String center;
    @SerializedName("title")
    private String title;
    @SerializedName("keywords")
    private String[] keywords;
    @SerializedName("nasa_id")
    private String nasaId;
    @SerializedName("date_created")
    private String dateCreated;
    @SerializedName("media_type")
    private String mediaType;
    @SerializedName("description")
    private String description;

    public String getCenter() {
        return center;
    }

    public String getTitle() {
        return title;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public String getNasaId() {
        return nasaId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getDescription() {
        return description;
    }
}