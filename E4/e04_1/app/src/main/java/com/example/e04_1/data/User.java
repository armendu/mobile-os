package com.example.e04_1.data;

import com.example.e04_1.enums.Gender;
import com.example.e04_1.enums.Role;

public class User {

    private String id;
    private String name;
    private String biography;
    private String imageUrl;
    private Gender gender;
    private Role role;

    public User() {

    }

    public User(String id, String name, String biography, String imageUrl, Gender gender, Role role) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.imageUrl = imageUrl;
        this.gender = gender;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
