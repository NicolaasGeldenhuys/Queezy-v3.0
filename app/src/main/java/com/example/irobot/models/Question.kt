package com.example.irobot.models

//Step One
//Firstly right clock com.example.irobot in this case and say new>package and call it models, then
//you will right click models and say new>kotlin class/files and name it Question and then select class.
//add data before class to make it a data class, data keyword = blueprint
//Also replace default curly brackets with normal brackets!
data class Question (
    val id: Int,
    val questionText:String,
    val icon: Int, //Say Int for images
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val optionFive: String,
    //val answer: Int

//Step Two
//Right click models folder and say new>Kotlin class/files and name it Constants and select Object,then go there.
)