package com.example.mobileproject;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class NasaSearchResponse {
    @SerializedName("collection")
    private NasaCollection collection;

    public NasaCollection getCollection() {
        return collection;
    }

    public static class NasaCollection {
        // Version is always "1.0"
        @SerializedName("version")
        private String version = "1.0";

        // Href follows a pattern
        private String hrefPattern = "https://images-api.nasa.gov/search?q=";

        @SerializedName("items")
        private List<NasaItem> items;

        public String getVersion() {
            return version;
        }

        // Construct href based on the query
        public String getHref(String query) {
            return hrefPattern + query;
        }

        public List<NasaItem> getItems() {
            return items;
        }
    }
}
