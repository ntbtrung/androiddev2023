package com.example.mobileproject;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class NasaCollection {
    private String version = "1.0";
    private String href = "https://images-api.nasa.gov";

    public String getVersion() {
        return version;
    }
    @SerializedName("items")
    private List<NasaItem> items;

    public List<NasaItem> getItems() {
        return items;
    }

    public String getHref() {
        return href;
    }

    public void setItems(List<NasaItem> items) {
        this.items = items;
    }

    public NasaCollection(String version, String href, List<NasaItem> items) {
        this.version = version;
        this.href = href;
        this.items = items;
    }
}
