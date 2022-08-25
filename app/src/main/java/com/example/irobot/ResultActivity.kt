package com.example.irobot

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.putInt
import android.util.Log
import com.example.irobot.databinding.ActivityQuestionBinding
import com.example.irobot.databinding.ActivityResultBinding
import com.example.irobot.models.Constants
import com.google.android.material.snackbar.Snackbar

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val finalScore = intent.getIntExtra("currentScore", 0)
        Log.i("Final Score: ", finalScore.toString())

        val username = intent.getStringExtra("username")

        binding.tvResults.text = "$finalScore/5"

        if(finalScore >= 5) {
            binding.tvMessage.text = "New highscore! $finalScore/5"

        } else {
            binding.tvMessage.text = "You can do better! $finalScore/5"

        }

        binding.imageView6.setOnClickListener {

            val intent = Intent(this, settings::class.java)

            var snackbar =  Snackbar.make(it, "Highscores Reset", Snackbar.LENGTH_LONG)
            snackbar.setAction("Ok") {
            }
            snackbar.show()

            intent.putExtra("finalScore", finalScore)

            startActivity(intent)
        }

        binding.btnHome.setOnClickListener {

            saveLastResults(username.toString(), finalScore)

            val intent = Intent(this, Categories::class.java)

            intent.putExtra("username", username)

            startActivity(intent)

            finish()
        }

        binding.btnAgain.setOnClickListener {

            saveLastResults(username.toString(), finalScore)

            val intent = Intent(this, questionActivity::class.java)

            if(finalScore > finalScore) {

                intent.putExtra("highscore",finalScore)
            }

            intent.putExtra("username", username)

            startActivity(intent)

            finish()
        }

        binding.imageView7.setOnClickListener {

            saveLastResults(username.toString(), finalScore)

            if(finalScore > finalScore) {
                intent.putExtra("highscore",finalScore)
            }

            val intent = Intent(this, questionActivity::class.java)

            intent.putExtra("username", username)
            startActivity(intent)

            finish()
        }
    }

    fun saveLastResults(username: String, result: Int){

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.apply {
            putString(Constants.LAST_USER, username)
            putInt(Constants.LAST_RESULT, result)
            apply() //To end

        }

        supportActionBar?.hide()
    }
}