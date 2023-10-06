package com.example.mobileproject;

public class NasaSearchResponse {

    private NasaCollection collection;

    public NasaSearchResponse(NasaCollection collection) {
        this.collection = collection;
    }

    public NasaCollection getCollection() {
        return collection;
    }

    public void setCollection(NasaCollection collection) {
        this.collection = collection;
    }


}
