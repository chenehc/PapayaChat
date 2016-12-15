package com.example.papaya.papayachat;

import java.io.Serializable;

public class Contact implements Serializable{
    private String name;
    private String profileIcon;

    public Contact(String name){
        this.name = name;
        this.profileIcon = "avatar_circle_blue_48dp";
    }

    public Contact (String name, String profileIcon){
        this.name = name;
        this.profileIcon = profileIcon;
    }

    public String getName() {
        return name;
    }

    public String getProfileIcon() {
        return profileIcon;
    }
}
