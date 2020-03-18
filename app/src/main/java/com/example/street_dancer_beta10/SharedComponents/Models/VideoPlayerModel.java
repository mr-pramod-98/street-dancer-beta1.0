package com.example.street_dancer_beta10.SharedComponents.Models;

public class VideoPlayerModel {

    private String title;
    private String media_url;
    private String thumbnail;
    private String description;

    public VideoPlayerModel() { }

    public VideoPlayerModel(String title, String media_url, String thumbnail, String description) {
        this.title = title;
        this.media_url = media_url;
        this.thumbnail = thumbnail;
        this.description = description;
    }

    public String getMedia_url() { return media_url;    }

    public String getThumbnail() { return thumbnail; }

    public String getDescription() {return description;}

}
