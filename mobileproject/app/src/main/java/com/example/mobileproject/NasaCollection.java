package com.example.mobileproject;

import java.util.List;

public class NasaCollection {
    private String version;
    private String href;
    private List<NasaItem> items;

    public NasaCollection(String version, String href, List<NasaItem> items) {
        this.version = version;
        this.href = href;
        this.items = items;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<NasaItem> getItems() {
        return items;
    }

    public void setItems(List<NasaItem> items) {
        this.items = items;
    }
}
