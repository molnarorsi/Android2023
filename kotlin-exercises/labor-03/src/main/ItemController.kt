package main

class ItemController(private var itemService: ItemService) {
    constructor() : this(ItemService())
    fun startQuiz(number: Int) {
        val items = itemService.selectRandomItems(number)
        var countCorrect = 0

        items.forEach{ item ->
            println("QUESTION: " + item.question)
            item.answers.forEachIndexed { index, answer ->
            println("${index + 1}: ${answer.second}")
        }
        print("Answer: ")
            var answer = readln().toInt()

            while(answer > item.answers.size || answer < 1) {
                print("\nWrong answer! Please try again! ")
                answer = readln().toInt()
            }

            if(item.answers[answer - 1].first == item.correct) {
                println("Hurray! Your answer is correct!\n")
                countCorrect += 1
            }
            else {
                println("Wrong! The correct answer is: ${item.correct}\n")
            }
        }

        println("Correct answers: $countCorrect")
        println("Total number of answers: ${items.size}")

        val prctg = (countCorrect.toDouble() / items.size.toDouble()) * 100
        println("Percentage: %.2f".format(prctg) + "%")

        when {
            prctg > 100.0 -> println("Big brain!")
            prctg == 100.0 -> println("Awesome!")
            prctg >= 90.0 -> println("Excellent!")
            prctg >= 80.0 -> println("Great work!")
            prctg >= 70.0 -> println("I know you can do better!")
            prctg >= 60.0 -> println("Well...you should study a little bit more!")
            else -> println("Oh no... :(")
        }
    }
}