package com.example.models

data class AuthorModel(
    val status:String,
    val total:Int,
    val data:AuthorInfo,
    val books:List<BooksInfo>
)
