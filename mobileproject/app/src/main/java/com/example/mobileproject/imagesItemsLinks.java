package com.example.mobileproject;

public class imagesItemsLinks {
    private static String href;

    private String rel = "preview";

    private String render = "image";

    public static String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getRender() {
        return render;
    }

    public void setRender(String render) {
        this.render = render;
    }
}
