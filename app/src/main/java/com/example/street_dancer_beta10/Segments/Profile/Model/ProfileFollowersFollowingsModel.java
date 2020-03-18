package com.example.street_dancer_beta10.Segments.Profile.Model;

public class ProfileFollowersFollowingsModel {

    private String Name;
    private String Status;
    private int photo;

    public ProfileFollowersFollowingsModel(String name, String status, int photo) {
        Name = name;
        Status = status;
        this.photo = photo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
