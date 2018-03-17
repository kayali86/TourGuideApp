package com.developer.kayali.tourguideapp;

public class Event {
    // Declare variables
    private int eventImageID, eventIconID;
    private String eventName, eventAddress, eventDescription;

    // Constructor
    public Event(int eventImageID, int eventIconID, String eventName, String eventAddress, String eventDescription) {
        this.eventImageID = eventImageID;
        this.eventIconID = eventIconID;
        this.eventName = eventName;
        this.eventAddress = eventAddress;
        this.eventDescription = eventDescription;
    }

    // Getters
    public int getEventImageID() {
        return eventImageID;
    }

    public int getEventIconID() {
        return eventIconID;
    }

    public String getEventName() {
        return eventName;
    }

    public String getAddress() {
        return eventAddress;
    }

    public String getDescription() {
        return eventDescription;
    }
}

