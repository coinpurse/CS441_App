package com.cs441_app;

public class User {
    private String UserID;
    private String Name;

    public User(){

    }

    public User(String name){
        Name = name;
    }
    public User(String userID, String name){
        UserID = userID;
        Name = name;
    }

    @Override
    public String toString(){
        return Name;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
