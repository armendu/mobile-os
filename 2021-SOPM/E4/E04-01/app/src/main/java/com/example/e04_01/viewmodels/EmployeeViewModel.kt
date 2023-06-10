package com.example.e04_01.viewmodels

import com.example.e04_01.enums.Gender
import com.example.e04_01.enums.Role

class EmployeeViewModel {
    var name: String? = null
    var biography: String? = null
    var imageUrl: String? = null
    var gender: Gender? = null
    var role: Role? = null

    constructor() {}
    constructor(
        name: String?,
        biography: String?,
        imageUrl: String?,
        gender: Gender?,
        role: Role?
    ) {
        this.name = name
        this.biography = biography
        this.imageUrl = imageUrl
        this.gender = gender
        this.role = role
    }
}