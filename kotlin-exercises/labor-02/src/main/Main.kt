package main
import IDictionary
import ListDictionary
import TreeSetDictionary
import kotlin.system.exitProcess

fun main(args: Array<String>){
    while(true) {
        print("Enter the number of the exercise(Enter 0 to exit!): ")
        val exercise = readlnOrNull()
        if(exercise == null || exercise == "") {
            println("Please enter a valid exercise number!")
            continue
        }

        val number = try {
            exercise.toInt()
        } catch (err: NumberFormatException) {
            println("'$exercise' is not a number!")
            continue
        }

        when(number) {
            0 -> {
                exitProcess(0)
            }
            1 -> exercise1()
            2 -> exercise2()
        }
    }
}


fun exercise1() {
    val dict: IDictionary = HashSetDictionary
    println("Number of words: ${dict.size()}")
    var word: String?
    while(true){
        print("What to find? ")
        word = readlnOrNull()
        if( word.equals("quit")){
            break
        }
        println("Result: ${word?.let { dict.find(it) }}")
    }
}

fun exercise2() {
    val name = "John Smith"
    println(name.monogram())
}

//functions for exercise 2
fun String.monogram(): String = this.split(" ").map {it.first()}.joinToString ("")

