package com.exemple.eternel.pojo;

/**
 * Created by eternel on 05/04/15.
 */
public class User {
    String username;
    String email;
    boolean staff;

    public User()
    {

    }

    public User(String username, String email, boolean staff)
    {
        this.username = username;
        this.email = email;
        this.staff = staff;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStaff() {
        return staff;
    }

    public void setStaff(boolean staff) {
        this.staff = staff;
    }
}
