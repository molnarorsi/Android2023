package main
import IDictionary
import ListDictionary
import TreeSetDictionary
import kotlin.random.Random
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
            3 -> exercise3()
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
    print("The monogram of $name is: ")
    println(name.monogram())

    val list = listOf("apple", "pear", "melon")
    print("Elements of the list are: $list \n")
    println("Elements separated by '#': ")
    println(list.joinStringsWithSeparator())


    val list2 = listOf("apple", "pear", "strawberry", "melon")
    print("Elements of the list are: $list2 \n")
    println("Longest string in the list is: ")
    println(list2.longestString())
}

//functions for exercise 2
fun String.monogram(): String = this.split(" ").map {it.first()}.joinToString ("")
fun List<String>.joinStringsWithSeparator(separator: String = "#") = this.joinToString(separator) {it}
fun List<String>.longestString() = this.maxByOrNull { it.length }

fun exercise3() {
    val date = Date()

    println("Invalid dates are: ")
    val dates = mutableListOf<Date>()
    while(dates.size < 10) {
        val rand = Date(
            Random.nextInt(1800,2080),
            Random.nextInt(1, 21),
            Random.nextInt(1, 37)
        )

        if(rand.isValid()) {
            dates.add(rand)
        }
        else {
            println(rand)
        }
    }

    println("\nValid dates are: ")
    dates.forEach{ println(it) }

    println("\nSorted dates are: ")
    dates.sort()
    dates.forEach(::println)
    println()

    println("\nReversed list is: ")
    dates.reverse()
    dates.forEach(::println)
    println()

    println("\nCustom order: ")
    dates.sortWith(Date)
    dates.forEach(::println)
    println()
}