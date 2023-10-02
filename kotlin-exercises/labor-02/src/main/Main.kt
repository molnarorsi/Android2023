package main
import IDictionary
import ListDictionary
import TreeSetDictionary

fun main(){
    exercise1()
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