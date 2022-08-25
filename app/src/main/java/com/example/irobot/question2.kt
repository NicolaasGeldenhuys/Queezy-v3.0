package com.example.irobot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import com.example.irobot.databinding.ActivityQuestionBinding
import com.example.irobot.models.Constants
import com.example.irobot.models.Question
import com.google.android.material.snackbar.Snackbar

class question2 : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username").toString()

        var questionNumber = intent.getIntExtra("questionNumber", 0)

        var currentScore = intent.getIntExtra("currentScore",  0)

        var questions = Constants.getAllQuestions2()

        val currentQuestion = questions[questionNumber]

        Log.i("Question Count: ", "${currentQuestion.questionText}")

        updateUI(currentQuestion, username)

        binding.btnNext.setOnClickListener {

            var selectedAnswer = binding.rgAnswers.checkedRadioButtonId

            if(selectedAnswer == -1) {

                var snackbar =  Snackbar.make(it, "Please enter your answer", Snackbar.LENGTH_SHORT)
                snackbar.setAction("Ok") {
                    Log.i("Ok Snackbar", "Yes!")
                }
                snackbar.show()

            } else {

                var userAnswer = findViewById<RadioButton>(selectedAnswer) // find view that has been selected that is a radio button id

                Log.i("Selected Answer ", userAnswer.text.toString())


                if(userAnswer.text.toString() == currentQuestion.optionOne) {

                    currentScore += 1

                    Log.i("Correct?", "Yes")

                }

                if (questionNumber + 1 == questions.count()){

                    val intent = Intent(this,ResultActivity::class.java)

                    intent.putExtra("currentScore", currentScore)
                    intent.putExtra("username",username)

                    startActivity(intent)
                    finish()

                } else { //This means user has selected an answer, let's check if it's correct

                    // %% 4. Navigate to next question
                    val intent = Intent(this, question2::class.java)

//             Pass username and next question
                    intent.putExtra("username",username)
                    intent.putExtra("questionNumber",questionNumber + 1)

                    intent.putExtra("currentScore", currentScore)

                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    private fun updateUI(currentQuestion: Question, username: String){

        if (currentQuestion.id == 1) {
            binding.tvQuestionText.text = "Welcome ${username}! Your first question is: ${currentQuestion.questionText}"
            binding.textView14.text = "${username}"
        } else {
            binding.tvQuestionText.text = "${username}, your next question is: ${currentQuestion.questionText}"
            binding.textView14.text = "${username}"
        }

        binding.rbAnswerOne.text = currentQuestion.optionOne
        binding.rbAnswerTwo.text = currentQuestion.optionTwo
        binding.pbLine.progress = currentQuestion.id
        binding.tvProgress.text = currentQuestion.id.toString() +"/5"

        supportActionBar?.hide()
    }

}