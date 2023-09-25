package main

fun main(args: Array<String>) {
   while(true) {
       print("Enter the number of the exercise:")
       val exercise = readLine()
       if(exercise == null || exercise == "") {
           println("Please enter a valid exercise number!")
           continue
       }

       val number = try {
           input.toInt()
       } catch (err: NumberFormatException) {
           println("'$input' is not a number!")
           continuue
       }

       }
   }
}

//-------------EXERCISE 1.-------------//

fun stringTemplate() {
    val nr1 = 2
    val nr2 = 3
    println("$nr1 + $nr2 = ${nr1 + nr2}")
}