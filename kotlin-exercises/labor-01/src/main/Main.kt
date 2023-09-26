package main

import kotlin.system.exitProcess

fun main(args: Array<String>) {
   while(true) {
       print("Enter the number of the exercise: \nEnter 0 to exit!")
       val exercise = readLine()
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
           1 -> stringTemplate()
           2 -> daysList()
       }
   }
}

//-------------EXERCISE 1.-------------//

fun stringTemplate() {
    val nr1 = 2
    val nr2 = 3
    println("$nr1 + $nr2 = ${nr1 + nr2}")
}

//-------------EXERCISE 2.-------------//
fun daysList() {
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    printListToConsole(daysOfWeek)
    startingWithLetter(daysOfWeek, "T")
}

//Use a for loop that iterates over the list and prints the list to the standard output.
fun printListToConsole(list: List<String>) {
    list.forEach(::println)
}

//Use a list filter to print the days starting with letter ‘T’
fun startingWithLetter(list: List<String>, letter: String) {
    list.filter { it.startsWith(letter) }.forEach({ println(it) })
}