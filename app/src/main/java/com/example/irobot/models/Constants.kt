package com.example.irobot.models

import com.example.irobot.R

object Constants {

// Constants for sharedprefrence consistency
    val USER_NAME: String = "username"
    val LAST_USER: String = "lastuser"
    val LAST_RESULT: String = "lastresult"

    //The following data will be captured from the Question class
    //Question and Constants classes essentially work together where one is a dataclass and the other is an object.

//    Create Array
    fun getAllQuestions() : ArrayList<Question> {
        var allQuestions = ArrayList<Question>()

        val que1 = Question(
            1,
            "What are Escargots?",
            R.drawable.ic_lemon2,
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

        //Add question to array
            allQuestions.add(que1)
            allQuestions.add(que2)
            allQuestions.add(que3)
            allQuestions.add(que4)
            allQuestions.add(que5)

    //  Return Data
        return allQuestions
    }

    fun getAllQuestions2() : ArrayList<Question> {
        // Create array
        var allQuestions = ArrayList<Question>()

        // Create Data
        val que1 = Question(
            1,
            "What is the best selling soup in UK?",
            R.drawable.ic_lemon2,
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

        //Add question to array
        allQuestions.add(que1)
        allQuestions.add(que2)
        allQuestions.add(que3)
        allQuestions.add(que4)
        allQuestions.add(que5)

        //  Return Data
        return allQuestions
    }

    fun getAllQuestions3() : ArrayList<Question> {
        // Create array
        var allQuestions = ArrayList<Question>()

        // Create Data
        val que1 = Question(
            1,
            "Tea is the most consumed manufactured drink in the world.",
            R.drawable.ic_lemon2,
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

        //Add question to array
        allQuestions.add(que1)
        allQuestions.add(que2)
        allQuestions.add(que3)
        allQuestions.add(que4)
        allQuestions.add(que5)

        //  Return Data
        return allQuestions
    }
}