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

    // 1.Here we do the same as in questionsActivity
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    // 2. Same process as questionsactivity
        binding = ActivityMainBinding.inflate(layoutInflater)

    // 3. Once again the same as in questionactivity example, we replace the R.layout.activity_main with binding.root
        setContentView(binding.root) //This sets what XML frontend to use



        val finalScore = intent.getIntExtra("currentScore", 0)

//        "" 37 Get the prev results
        binding.fabInfo.setOnClickListener{

            val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
            val lastUser = sharedPref.getString(Constants.LAST_USER, "None")
            val lastResult = sharedPref.getInt(Constants.LAST_RESULT, 0)

            val toast = Toast.makeText(this, "Last User: $lastUser ($lastResult)",Toast.LENGTH_LONG)
            toast.show()
        }


    //Now go to mainactivity layout to change things commented with !!

    //We're back from mainactivity layout and now we are changing new things!

    //Example of getting access to my button for clicks, FYI select 2nd onclicklistener option
        binding.btnStart.setOnClickListener {



    //Next let's get our input value and add validation with a toast or snackbar

        //Functionality On Click
        // Get access to input value
        val username = binding.etUsername.text


        //Check if username is empty
        if(username.toString() == ""){
            //Add validation (Toast or snackbar)

        //Toast example

//        Toast.makeText(this,
//            "Please enter your name",
//            Toast.LENGTH_LONG)
//            .show()

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

            //Intent navigation (context from where intent happens, and where current activity should go to new one)
            val intent = Intent(this, Categories::class.java)
//
//       1. ****If we want to pass the data of edittext to a new activity, name of variable followed by the val name****
//          You can declare username in the constants file to be able to use this throughout the project
//      2. Go to the question activity.kt beneath setContentView to further finish this process.
            intent.putExtra("username", username.toString())

            intent.putExtra("lastRes", finalScore)


//            This makes activity go to next chosen activity in the code above
            startActivity(intent)
            //finish() //To Close current activity from back stack, aka closes app when you hit back button

//            Add the code below if you dont want to be able to go back to previous page/activity when you tapped the button for the next page/activity.
//          finish()



        }


        }



//        finish() //        If you dont want back button to go back to prev page



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