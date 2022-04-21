package com.example.e03_01.viewmodels;

public enum Role {
    IT("It"),
    HR("Hr"),
    Finance("Finance");

    private final String description;

    Role(String role) {
        this.description = role;
    }

    public String getDescription() {
        return description;
    }
}
