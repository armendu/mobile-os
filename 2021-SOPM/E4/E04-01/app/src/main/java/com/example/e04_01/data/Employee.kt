package com.example.e04_01.data

class Employee {
    var username: String? = null
    var email: String? = null

    constructor() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    constructor(username: String?, email: String?) {
        this.username = username
        this.email = email
    }
}