package main
import IDictionary
import ListDictionary

fun main(){
    val dict: IDictionary = ListDictionary
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
