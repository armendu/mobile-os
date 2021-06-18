package com.example.e03_01.viewmodels;

public class Employee {
    private String name;
    private String description;
    private Gender gender;
    private Role role;

    public Employee() {

    }

    public Employee(String name, String description, Gender gender, Role role) {
        this.name = name;
        this.description = description;
        this.gender = gender;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
