package com.example.street_dancer_beta10.Segments.Notification.Model;

public class NotificationModel {

    private String Sender;
    private String Details;
    private String Time;

    public NotificationModel(String Sender, String Details, String Time) {
        this.Sender = Sender;
        this.Details = Details;
        this.Time = Time;
    }

    public String getSender() {
        return Sender;
    }

    public String getDetails() {
        return Details;
    }

    public String getTime() {
        return Time;
    }
}
