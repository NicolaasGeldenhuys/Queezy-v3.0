package com.example.irobot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.irobot.databinding.ActivityMainBinding
import com.example.irobot.models.Constants
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //This sets what XML frontend to use

        val finalScore = intent.getIntExtra("currentScore", 0)

        binding.fabInfo.setOnClickListener{

            val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
            val lastUser = sharedPref.getString(Constants.LAST_USER, "None")
            val lastResult = sharedPref.getInt(Constants.LAST_RESULT, 0)

            val toast = Toast.makeText(this, "Last User: $lastUser ($lastResult)",Toast.LENGTH_LONG)
            toast.show()

        }

        binding.btnStart.setOnClickListener {

        //Functionality On Click
        // Get access to input value
        val username = binding.etUsername.text

        //Check if username is empty
        if(username.toString() == ""){

          var snackbar =  Snackbar.make(it, "Please enter your name", Snackbar.LENGTH_LONG)
                snackbar.setAction("Ok") {
                Log.i("Ok Snackbar", "Yes!")
                }
            snackbar.show()

            //add validation on the view itself
            binding.etUsername.error = "Please add your username"

        } else {
            Log.i("Clicked","$username")

            ////        ****NAVIGATE TO NEXT ACTIVITY****
            val intent = Intent(this, Categories::class.java)

            intent.putExtra("username", username.toString())
            intent.putExtra("lastRes", finalScore)

            startActivity(intent)
        }

        }

        //        Add navigation to settings
        binding.imageView.setOnClickListener{
            val intent = Intent(this, settings::class.java)

            var snackbar =  Snackbar.make(it, "Highscores Reset", Snackbar.LENGTH_LONG)
            snackbar.setAction("Ok") {
            }
            snackbar.show()
            startActivity(intent)
            intent.putExtra("finalScore", finalScore)
        }

        supportActionBar?.hide()
    }
}