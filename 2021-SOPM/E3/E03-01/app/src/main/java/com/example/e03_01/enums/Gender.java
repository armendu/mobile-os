package com.example.e03_01.enums;

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
