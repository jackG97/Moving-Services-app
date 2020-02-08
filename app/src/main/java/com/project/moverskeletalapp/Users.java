package com.project.moverskeletalapp;

public class Users {
    private String userID;
    private String username;
    private String userEmail;
    private String userPassword;

    public Users(){

    }

    public Users(String userID, String username, String userEmail, String userPassword) {
        this.userID = userID;
        this.username = username;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
