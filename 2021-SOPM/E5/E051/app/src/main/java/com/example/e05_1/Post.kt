package com.example.e05_1

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Post {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("body")
    @Expose
    var body: String? = null

    @SerializedName("userId")
    @Expose
    var userId: Int? = null
}