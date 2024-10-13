package com.oop.models;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseUser implements Persistable {
    protected String username;
    protected String password;
    protected String email;
    protected String profilePicture;

    public BaseUser(String username, String password, String email, String profilePicture) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.profilePicture = profilePicture;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getProfilePicture() {
        return this.profilePicture;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public abstract void delete();
    public abstract void onLogin(HttpServletRequest request, HttpServletResponse response) throws IOException;

    @Override
    public String toString() {
        return "User " + this.getUsername();
    }
}
