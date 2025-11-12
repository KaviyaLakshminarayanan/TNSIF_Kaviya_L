package com.tns.fooddeliverysystem.entities;

public class User {
    protected int userId;
    protected String username;
    protected long contactNo;

    public User(int userId, String username, long contactNo) {
        this.userId = userId;
        this.username = username;
        this.contactNo = contactNo;
    }

    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public long getContactNo() { return contactNo; }

    @Override
    public String toString() {
        return String.format("User{id=%d,name='%s',contact=%d}", userId, username, contactNo);
    }
}
