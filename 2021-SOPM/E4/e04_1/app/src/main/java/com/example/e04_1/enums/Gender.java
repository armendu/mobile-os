package com.example.e04_1.enums;

public enum Gender {
    Female("Female"),
    Male("Male"),
    Unknown("Male");

    private final String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
