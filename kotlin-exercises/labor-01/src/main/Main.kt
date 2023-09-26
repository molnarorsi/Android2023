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
