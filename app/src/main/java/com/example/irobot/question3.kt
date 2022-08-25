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

class question3 : AppCompatActivity() {

    //$$ 1.We need to define our binding view, choose current activity in binding
    private lateinit var binding: ActivityQuestionBinding
    //$$

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //$$ 2.Inflates our activities binding into our content
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        //$$

        //$$ 3. Change r.layout etc. to binding.root
        setContentView(binding.root)
        //$$


        //       3. ****This code is part of main activity to do with the code intent.PutExtra etc. this is to show username in other activity f.e.
        val username = intent.getStringExtra("username").toString()
//        ****4. Now go to example of binding.tvQuestionText down below to continue code by replacing everything in "" with username in this example****
//            ***** End of this code

//        %% 7. get the question Number from previous activity
        var questionNumber = intent.getIntExtra("questionNumber", 0)
//        %% 8. Change val currentQuestion = questions[0] down below from currentQuestion to val currentQuestion = questions[questionNumber]
//          %% 9. Go down the page to step 10 marked with %%


//        "" 16 get the current score from prev question
        var currentScore = intent.getIntExtra("currentScore",  0)
//      "" 17 Go down to comment "" 18 and update score

        //1. Call for all my questions
        var questions = Constants.getAllQuestions3()

//      ^^  Newest set of code, skip this if you haven finished process above!
//       1. ^^ Select current question
        val currentQuestion = questions[questionNumber]
//       2. ^^ After we chose our specific question above let's log that below and replace ${questions.size} with ${currentQuestion.questionText}
//       3. ^^ Then we also replace the binding.tvQuestionText.text = "${username}.${questions[1].questionText}" with binding.tvQuestionText.text = "${username}.${currentQuestion.questionText}"
//       4. Move down to next comment on this page that starts with ^^

        //Log under info in logcat the question count in this case
        //Add text/tag first, then a comma and then what you want to call, in this case its the total questions, concatenate it with "${}"
        Log.i("Question Count: ", "${currentQuestion.questionText}")

        //Now go to manifest and make sure correct the activity you want to display
        //in this case questionActivity is exported="true" and replace /> with </activity> and make the other activities exported as ="false and cut intentfilter and add it into the activity you want to have to show currently"

        //linking layout and activity id
        //Go to 2nd build.gradle script to do binding and go underneath "build type" code
        //Then go to the top of this activity to change a few things labelled under comments with $$, look for 4 steps, with step 4 being under this comment

        //$$ 4.Add binding below after previous steps

//    **** Newer code mixed in between older code refer to start symbols as reference of where to continue coding   **** 4. Now we replace what was originally questions[1].questionText with the following ****

        //      **** Now you should be able to see entered username in next activity
        // ****End of capturing data in prev activity and displaying in new one
        // ****Next we move onto activity questions layout and started making the UI for that activity, after that we come back here to comments labelled with ^^

        //$$ This is used to update values in our activities, we need to do this for each activity when we want to update its values
        //$$ Just pay attention above that here we don't say tv_Question_Text like in other part, we have no _'s
        //You can set everything in brackets equal to either just text using ""'s or display an array like above


        // R.id.tv_question_text.setText(questions[0].questionText)


        // 2. %% Bind all question info to view values
        updateUI(currentQuestion, username)


        // %% 3. Handle next question click
        binding.btnNext.setOnClickListener {

//            "" 10 Capture the answered question input
            var selectedAnswer = binding.rgAnswers.checkedRadioButtonId

// "" 11           Make if statement to check for checked buttons, -1 means user has not selected and answer
// "" 12           Then we create toast to notify user that they should select an answer, remember to type out LENGTH_SHORT and the hit import

            if(selectedAnswer == -1) {
//                val toast = Toast.makeText(this, "Please select your answer", Toast.LENGTH_SHORT)
//                toast.show()


                var snackbar =  Snackbar.make(it, "Please enter your answer", Snackbar.LENGTH_SHORT)
                snackbar.setAction("Ok") {
                    Log.i("Ok Snackbar", "Yes!")
                }
                snackbar.show()
            } else {
// "" 13               Find what user selected
// ""               In terms of Radio buttons -1 means not selected, 0 means 1st button selected, 1 = 2nd button etc.
                var userAnswer = findViewById<RadioButton>(selectedAnswer) // find view that has been selected that is a radio button id

                Log.i("Selected Answer ", userAnswer.text.toString())

//                "" 14 Check Current Answer, the if statement will check if it will equal your correct answer, you can replace currentQuestion.optionOne with "Question Answer" too if you're struggling
                if(userAnswer.text.toString() == currentQuestion.optionOne) {

//                    "" 15 Go add score as a value above with comment marked "" 16

//                    "" 18 Update currentscore with below code
                    currentScore += 1

                    Log.i("Correct?", "Yes")
//                    "" 18 Current score updated, go to  "" 19 down below
//              Here you can updateUi to see correctness in real time
                }


//            (( 1. Creating if statement to move on to new activity when 5 questions have been asked
//            (( PLEASE NOTE THAT THE CONTENT DONE IN PREV PROCESS MARKED %% has been added into this if statement
//            (( 2. Create new empty activity ResultActivity

                if (questionNumber + 1 == questions.count()){

//            (( 3. Finish if Statement
                    val intent = Intent(this,ResultActivity::class.java)
//            (( 4. Pass the final score

//              ""   19 Pass Score and username, copy past below line by "" 20 below
                    intent.putExtra("currentScore", currentScore)
                    intent.putExtra("username",username)

                    startActivity(intent)
                    finish()

                } else { //This means user has selected an answer, let's check if it's correct

                    // %% 4. Navigate to next question
                    val intent = Intent(this, question3::class.java)

//            %% 10. Change below intent.putExtra("questionNumber",1) to intent.putExtra("questionNumber",questionNumber++)
//            %% 11. ++ increments questionnumber by 1 each time so that it moves on to next question after button is clicked.
//            %% 12. End of this process, up to (( marked comments to create if statement to realize when last question has been filled in.

//            %% 5. Pass username and next question
                    intent.putExtra("username",username)
                    intent.putExtra("questionNumber",questionNumber + 1)

//                    "" 20 just pass score for else statement as well
                    intent.putExtra("currentScore", currentScore)
//                  "" 21 Now go to resultactivity and get scores
                    startActivity(intent)
                    finish()

                    // %% 6. Move up to step 7 marked with %%

                }

            }




        }
    }



    //    %% Function to update frontend
//   1. %% Time stamp for class recording 1:16:45. we just cut the entire process of swapping between questions and pasted it here to 'Clean Up our code'
    private fun updateUI(currentQuestion: Question, username: String){

        if (currentQuestion.id == 1) {
            binding.tvQuestionText.text = "Welcome ${username}! Your first question is: ${currentQuestion.questionText}"

            binding.textView14.text = "${username}"

        } else {
            binding.tvQuestionText.text = "${username}, your next question is: ${currentQuestion.questionText}"

            binding.textView14.text = "${username}"

        }



        //        ^^ 5. Now we bind all question info to view its values
        binding.rbAnswerOne.text = currentQuestion.optionOne
        binding.rbAnswerTwo.text = currentQuestion.optionTwo
//        binding.ivIcon.setImageResource(currentQuestion.icon)
//        ^^ End of this process ^^ Move up this page to symbols %% to update frontend


        //        "" 7 Setup our progress bar
// "" 8   We went to question layout and gave progress bar and text of progress bar each an id
        binding.pbLine.progress = currentQuestion.id
        binding.tvProgress.text = currentQuestion.id.toString() +"/5"

// "" 9   After adding above bindings let's go and capture our values above marked "" 10

        supportActionBar?.hide()

    }
}