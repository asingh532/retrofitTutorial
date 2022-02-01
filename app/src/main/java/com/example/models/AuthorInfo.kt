package com.example.models

import com.google.gson.annotations.SerializedName

data class AuthorInfo(
    val id: String,
    val name: String,
    val username: String,
    val gender: String,
    val bornT: String,
    val country: String,
    val profession: String,
    val genre: String,
    val genrePreference: String,
    val website: String,
    val videoUrl: String,
    val videoTitle: String,
    val facebookUrl: String,
    val twitterUrl: String,
    val linkedinUrl: String,
    val goodreadsUrl: String,
    val googleplusUrl: String,
    val instagramUrl: String,
    val pinUrl: String,
    @SerializedName("package") var userPackageType: String? = null,
    val usersView:String,
    val image:String,
    val about:String,
    val bestSeller:String,
    val booksCount:String,
    val amazonUrl:String,
    val newsletterUrl:String,
    val amazonrank:String,
    )
