package com.example.e04_01.data;

public class Employee {
    public String username;
    public String email;

    public Employee() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Employee(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
