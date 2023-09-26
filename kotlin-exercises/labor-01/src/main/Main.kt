package main

import java.util.Base64
import kotlin.system.exitProcess

fun main(args: Array<String>) {
   while(true) {
       print("Enter the number of the exercise: \nEnter 0 to exit!")
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
           1 -> stringTemplate()
           2 -> daysList()
           3 -> primeNumbersInGivenRange(IntRange(1, 20))
           4 -> encodeAndDecodeMessage()
           5 -> {
               printEvenNumbers((1..10).toList())
           }
           6 -> mapOperations()
           7 -> mutableList()
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
    containsLetter(daysOfWeek, "e")
    dayOfLength(daysOfWeek, 6)
}

//Use a for loop that iterates over the list and prints the list to the standard output.
fun printListToConsole(list: List<String>) {
    println("List:\n")
    list.forEach(::println)
}

//Use a list filter to print the days starting with letter ‘T’
fun startingWithLetter(list: List<String>, letter: String) {
    println("\nDays starting with letter $letter:\n")
    list.filter { it.startsWith(letter) }.forEach { println(it) }
}

//Use a list filter to print the days containing the letter ‘e’
fun containsLetter(list: List<String>, letter: String) {
    println("\nDays containing the letter $letter:\n")
    list.filter { it.contains(letter) }.forEach { println(it) }
}

//Use a list filter to print all the days of length 6 (e.g. Friday)
fun dayOfLength(list: List<String>, length: Int) {
    println("\nDays with given length $length:")
    list.filter { it.length == length }.forEach { println(it) }
}

//-------------EXERCISE 3.-------------//
fun isPrimeNumber(number: Int): Boolean {
    for (i in 2..number / 2) {
        if (number % i == 0) {
            return false
        }
    }
    return true
}

fun primeNumbersInGivenRange(range: IntRange) {
    println("Prime numbers in the $range range:\n")
    range.filter { isPrimeNumber(it) }.forEach{print("$it, ")}
    print("\n")
}

//-------------EXERCISE 4.-------------//
fun encodeAndDecodeMessage() {
    val originalMessage = "Hello from the other side! :)"

    val encodedMessage = messageCoding(originalMessage, ::encodeMessage)
    val decodedMessage = messageCoding(encodedMessage, ::decodeMessage)

    println("Original message: $originalMessage")
    println("Encoded message: $encodedMessage")
    println("Decoded message: $decodedMessage")
}
fun encodeMessage(msg: String): String {
    val encodedBytes = Base64.getEncoder().encode(msg.toByteArray())
    return String(encodedBytes)
}

fun decodeMessage(encodedMsg: String): String {
    val decodedBytes = Base64.getDecoder().decode(encodedMsg.toByteArray())
    return String(decodedBytes)
}

fun messageCoding(msg: String, func: (String) -> String): String {
    return func(msg)
}

//-------------EXERCISE 5.-------------//
fun printEvenNumbers(numbers: List<Int>) = numbers.filter { it % 2 == 0 }.forEach { print(it) }

//-------------EXERCISE 6.-------------//
fun mapOperations() {
    val integers = (1..5).toList()
    print("The numbers are: $integers")
    println("\nThe doubled numbers are: ${doubleListElements(integers)}")

    val dayOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    print("\nThe days of the week capitalized: ")
    capitalize(dayOfWeek)
    print("\n")

    print("\nFirst character of each day is: ")
    firstChar(dayOfWeek)
    print("\n")

    print("\nThe length of each day is: \n")
    lengthOfDay(dayOfWeek)
    print("\n")

//Compute the average length of days (in number of characters)
    val avg = dayOfWeek.map {it.length}.average()
    println("\nThe average length of each day is: $avg\n")
}


//Double the elements of a list of integers and print it.
fun doubleListElements(numbers: List<Int>) = numbers.map { it * 2 }


//Print the days of week capitalized (e.g. MONDAY for Monday)
fun capitalize(list: List<String>) {
    list.map {it. uppercase()}.forEach{print("$it ")}
}

//Print the first character of each day capitalized (e.g. m for Monday)
fun firstChar(list: List<String>) {
    list.map {it. first().lowercase()}.forEach{print("$it ")}
}

//Print the length of days (number of characters, e.g. Monday → 6)
fun lengthOfDay(list: List<String>) {
    list.map{Pair(it.length, it)}.forEach{println("${it.first} -> ${it.second}")}
}

//-------------EXERCISE 7.-------------//

fun mutableList() {
    val dayOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    //Convert the daysOfWeek immutable list into a mutable one. Remove all days containing
    //the letter ‘n’, then print the mutable list.
    val mutableDay = dayOfWeek.toMutableList()
    mutableDay.removeAll{it.contains("n")}
    print("Days of week without letter N: \n")
    mutableDay.forEach{print("$it ")}

    //Print each element of the list in a new line together with the index of the element (convert
    //the list to list with index using the withIndex() function!).
    val indexMutableList = mutableDay.withIndex()
    print("The indexed list is: \n")
    indexMutableList.forEach{ println("Day at ${it.index} is ${it.value} \n") }

    //Sort the result list alphabetically!
    mutableDay.sort()
    println("\nDays sorted alphabetically: \n")
    mutableDay.forEach{print("$it \n")}
}