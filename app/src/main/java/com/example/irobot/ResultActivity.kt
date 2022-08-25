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

//""1    Set Lateinit etc. to Activity name with Binding at the end
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//""2        Add binding layoutinflatr
        binding = ActivityResultBinding.inflate(layoutInflater)
//""3      Replace everything in brackets with Binding.root
        setContentView(binding.root)
//""4 Go to activity question in layout and add progress bar marked with ""

//  "" 22      Get scores
        val finalScore = intent.getIntExtra("currentScore", 0)

        Log.i("Final Score: ", finalScore.toString())

//        "" 30 add username value
        val username = intent.getStringExtra("username")

//  "" 23      Display our score
//        GO give imageview an ID
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



//   "" 24     Handle the navigation clicks for home button
        binding.btnHome.setOnClickListener {
//            "" 33 Code in between the followin comments are part of 33, the rest of binding is a part of 24th comment
            saveLastResults(username.toString(), finalScore)
//              "" End of "" 33, copy paste te code of 33 in 34 "" as well

            val intent = Intent(this, Categories::class.java)

            intent.putExtra("username", username)



            startActivity(intent)

            finish()
        }
// "" 25 Set back button navigation
        binding.btnAgain.setOnClickListener {

//            "" 34 paste this below
            saveLastResults(username.toString(), finalScore)
//            "" End of 34,  of binding is part of "" 25

            val intent = Intent(this, questionActivity::class.java)

            if(finalScore > finalScore) {

                intent.putExtra("highscore",finalScore)
            }

//            "" 35 paste intent
            intent.putExtra("username", username)
//          "" end of 35, rest is part of 25, go to mainactivity frontend for "" 36

            startActivity(intent)

            finish()
        }
// "" 26 Go add a constant value marked "" 27


        binding.imageView7.setOnClickListener {

//            "" 34 paste this below
            saveLastResults(username.toString(), finalScore)
//            "" End of 34,  of binding is part of "" 25

            if(finalScore > finalScore) {

                intent.putExtra("highscore",finalScore)
            }

            val intent = Intent(this, questionActivity::class.java)

//            "" 35 paste intent
            intent.putExtra("username", username)
//          "" end of 35, rest is part of 25, go to mainactivity frontend for "" 36



            startActivity(intent)

            finish()
        }



    }

    //        "" 29 Save values with sharedpreferences
    fun saveLastResults(username: String, result: Int){

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

//        "" 30 GO add username val by comment 31 "" above, Constants. refers to constant we made for result and username
        editor.apply {
            putString(Constants.LAST_USER, username)
            putInt(Constants.LAST_RESULT, result)
            apply() //To end
//            ""32 in video we cut and paste above work in a new function down below at 33, but in our case we just copied the 'functioned' format over already
        }

        supportActionBar?.hide()


    }
}