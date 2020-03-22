package com.example.street_dancer_beta10.SharedComponents.Models;

public class MediaObject {

    private String title;
    private String media_url;
    private String thumbnail;
    private String description;

    public MediaObject() { }

    public MediaObject(String title, String media_url, String thumbnail, String description) {
        this.title = title;
        this.media_url = media_url;
        this.thumbnail = thumbnail;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getMedia_url() {
        return media_url;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
