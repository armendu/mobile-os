package com.example.e03_01.viewmodels;

public enum Gender {
    Male("Male"),
    Female("Female"),
    Unknown("Unknown");

    private final String description;

    Gender(String gender) {
        this.description = gender;
    }

    public String getDescription() {
        return description;
    }
}
