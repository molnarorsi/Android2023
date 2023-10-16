package main
import java.io.File

class ItemRepository {
    private var items = mutableListOf<Item>()

    init {
        val file = File("D:\\UNIVERSITY\\Negyedev\\Elso felev\\Android2023\\kotlin-exercises\\labor-03\\src\\resources\\questions.txt")
        val lines = file.readLines()
        var i = 0
        while(i < lines.size) {
            val question = lines[i++]
            val (numberOfAnswers, correctAnswerNumber) = lines[i++].split(" ").map(String::toInt)
            val answers = mutableListOf<Pair<Int, String>>()
            repeat(numberOfAnswers) {
                answers.add(Pair(it + 1, lines[i++]))
            }
            items.add(Item(question, answers, correctAnswerNumber))
        }
    }

    fun randomItem(): Item {
        return items.random()
    }

    fun save(item: Item) {
        items.add(item)
    }

    fun size(): Int {
        return items.size
    }

    fun printItems() {
        for(item in items) {
            print(item)
        }
    }
}