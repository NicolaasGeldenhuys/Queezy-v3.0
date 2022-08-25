package com.example.irobot.models

data class Question (
    val id: Int,
    val questionText:String,
    val icon: Int, //Say Int for images
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val optionFive: String,
)