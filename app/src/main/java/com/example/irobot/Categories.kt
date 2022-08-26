package com.example.irobot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.irobot.databinding.ActivityCategoriesBinding
import com.example.irobot.databinding.ActivityCategoriesBinding.inflate
import com.example.irobot.databinding.ActivityMainBinding
import com.example.irobot.models.Question
import com.google.android.material.snackbar.Snackbar

class Categories : AppCompatActivity() {

    private lateinit var binding: ActivityCategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username").toString()

// Update Highscores!
        val finalScore = intent.getIntExtra("currentScore", 0)
        binding.textView11.text = finalScore.toString()
        binding.textView17.text = finalScore.toString()
        binding.textView28.text = finalScore.toString()
        binding.imageView19.setOnClickListener {

            val intent = Intent(this, questionActivity::class.java)
            intent.putExtra("username", username.toString())
            startActivity(intent)
        }

        binding.imageView21.setOnClickListener {
            val intent = Intent(this, question2::class.java)
            intent.putExtra("username", username.toString())
            startActivity(intent)
        }

        binding.imageView25.setOnClickListener {
            val intent = Intent(this, question3::class.java)
            intent.putExtra("username", username.toString())
            startActivity(intent)
        }

// Settings
        binding.imageView15.setOnClickListener {
            val intent = Intent(this, settings::class.java)
            var snackbar =  Snackbar.make(it, "Highscores Reset", Snackbar.LENGTH_LONG)
            snackbar.setAction("Ok") {
            }
            snackbar.show()
            intent.putExtra("finalScore", finalScore)
            startActivity(intent)
        }

        // Back
        binding.imageView14.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        supportActionBar?.hide()
    }

}