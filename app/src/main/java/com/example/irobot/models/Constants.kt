package com.example.irobot.models

import com.example.irobot.R

object Constants {

//  "" 27 Constants for sharedprefrence consistency
    val USER_NAME: String = "username"
    val LAST_USER: String = "lastuser"
    val LAST_RESULT: String = "lastresult"
//  "" 28  Back to Result Activity kt for "" 29

    // Make a function to return all the questions. Add round brackets 1st and curly second
    //To do highlights in log bar what you still want to do.
    // In between the 2 types of brackets : and the arraylist, this will create an empty array
    //The following data will be captured from the Question class you just created under models
    //Question and Constants classes essentially work together where one is a dataclass and the other is an object.
    fun getAllQuestions() : ArrayList<Question> {
    //1. Create empty arraylist
        var allQuestions = ArrayList<Question>()

    //2. Create Data
        //TODO: Create Data

        val que1 = Question(
            //REMEMBER COMMAS AFTER THE FOLLOWING
            //Make " marks to have the autofilled things like ID adn questionText etc. then remove " afterwards
            //Give Id for que 1
            1,

            //Add Question's text
            "What are Escargots?",

            //Hit alt enter to import red text, in this case R, this is to display our icon.
            //R stands for res, so we are calling our resources aka res folder, then our drawable package and then the specified image inside drawable.
            //Add any vector or image here below instead of ic_help f.e.
            R.drawable.ic_lemon2,

            //Add options text
            "Land snails",
            "Frog Legs",
            "Test 3",
            "Test 4",
            "Test 5"


        )

        val que2 = Question(
            2,
            "What does BLT stand for? ",
            R.drawable.ic_lemon1,
            "Bacon, Lettuce, Tomato",
            "Baking, Layering, Toasting",
            "Test 3",
            "Test 4",
            "Test 5"
        )

        val que3 = Question(
            3,
            "What is spag bol? ",
            R.drawable.ic_lemon2,
            "Spaghetti Bolognese",
            "Swedish Meatballs",
            "Test 3",
            "Test 4",
            "Test 5"
        )

        val que4 = Question(
            4,
            "What type of food is Pumpernickel?",
            R.drawable.ic_lemon1,
            "Bread",
            "Vegetable",
            "Test 3",
            "Test 4",
            "Test 5"
        )

        val que5 = Question(
            5,
            "Grenadine is obtained from which fruit?",
            R.drawable.ic_lemon2,
            "Pomegranate",
            "Sweet Granadilla",
            "Test 3",
            "Test 4",
            "Test 5"
        )

        //Add question to array you created in Question class
            allQuestions.add(que1)
            allQuestions.add(que2)
            allQuestions.add(que3)
            allQuestions.add(que4)
            allQuestions.add(que5)

    //3.  Return Data
        return allQuestions
    }
//Go create new empty activity, in this case questionActivity and go on there









    fun getAllQuestions2() : ArrayList<Question> {
        //1. Create empty arraylist
        var allQuestions = ArrayList<Question>()

        //2. Create Data
        //TODO: Create Data

        val que1 = Question(
            //REMEMBER COMMAS AFTER THE FOLLOWING
            //Make " marks to have the autofilled things like ID adn questionText etc. then remove " afterwards
            //Give Id for que 1
            1,

            //Add Question's text
            "What is the best selling soup in UK?",

            //Hit alt enter to import red text, in this case R, this is to display our icon.
            //R stands for res, so we are calling our resources aka res folder, then our drawable package and then the specified image inside drawable.
            //Add any vector or image here below instead of ic_help f.e.
            R.drawable.ic_lemon2,

            //Add options text
            "Tomato",
            "Pumpkin",
            "Test 3",
            "Test 4",
            "Test 5"


        )

        val que2 = Question(
            2,
            "What French city does bouillabaisse originate from?",
            R.drawable.ic_lemon1,
            "Marseille",
            "Bordeaux",
            "Test 3",
            "Test 4",
            "Test 5"
        )

        val que3 = Question(
            3,
            "Calamari is a dish made from what animal?",
            R.drawable.ic_lemon2,
            "Squid",
            "Octopus",
            "Test 3",
            "Test 4",
            "Test 5"
        )

        val que4 = Question(
            4,
            "Which fast food chain has the most stores globally?",
            R.drawable.ic_lemon1,
            "Subway",
            "Mcdonald's",
            "Test 3",
            "Test 4",
            "Test 5"
        )

        val que5 = Question(
            5,
            "Which nuts are used in marzipan?",
            R.drawable.ic_lemon2,
            "Almonds",
            "Cashews",
            "Test 3",
            "Test 4",
            "Test 5"
        )

        //Add question to array you created in Question class
        allQuestions.add(que1)
        allQuestions.add(que2)
        allQuestions.add(que3)
        allQuestions.add(que4)
        allQuestions.add(que5)

        //3.  Return Data
        return allQuestions
    }








    fun getAllQuestions3() : ArrayList<Question> {
        //1. Create empty arraylist
        var allQuestions = ArrayList<Question>()

        //2. Create Data
        //TODO: Create Data

        val que1 = Question(
            //REMEMBER COMMAS AFTER THE FOLLOWING
            //Make " marks to have the autofilled things like ID adn questionText etc. then remove " afterwards
            //Give Id for que 1
            1,

            //Add Question's text
            "Tea is the most consumed manufactured drink in the world.",

            //Hit alt enter to import red text, in this case R, this is to display our icon.
            //R stands for res, so we are calling our resources aka res folder, then our drawable package and then the specified image inside drawable.
            //Add any vector or image here below instead of ic_help f.e.
            R.drawable.ic_lemon2,

            //Add options text
            "True",
            "False",
            "Test 3",
            "Test 4",
            "Test 5"


        )

        val que2 = Question(
            2,
            "You are unable to eat gluten with Coeliac disease.",
            R.drawable.ic_lemon1,
            "True",
            "False",
            "Test 3",
            "Test 4",
            "Test 5"
        )

        val que3 = Question(
            3,
            "Vermicelli is a pasta that means little worms.",
            R.drawable.ic_lemon2,
            "True",
            "False",
            "Test 3",
            "Test 4",
            "Test 5"
        )

        val que4 = Question(
            4,
            "A vanilla pod comes from an orchid.",
            R.drawable.ic_lemon1,
            "True",
            "False",
            "Test 3",
            "Test 4",
            "Test 5"
        )

        val que5 = Question(
            5,
            "Aduki, Borlotti & Cannellini are types of beans.",
            R.drawable.ic_lemon2,
            "True",
            "False",
            "Test 3",
            "Test 4",
            "Test 5"
        )

        //Add question to array you created in Question class
        allQuestions.add(que1)
        allQuestions.add(que2)
        allQuestions.add(que3)
        allQuestions.add(que4)
        allQuestions.add(que5)

        //3.  Return Data
        return allQuestions
    }
}