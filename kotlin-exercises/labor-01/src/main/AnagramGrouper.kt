package main

//-------------EXTRA EXERCISE-------------//

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val anagramGroups = mutableMapOf<String, MutableList<String>>()

    for (str in strs) {
        // Convert the string to a character array, sort it, and then convert it back to a string
        val sortedStr = str.toCharArray().apply { sort() }.joinToString("")

        // Add the word to the corresponding group
        anagramGroups.getOrPut(sortedStr) { mutableListOf() }.add(str)
    }

    println("Input words: ${strs.joinToString(", ")}")
    println("Anagram groups: ${anagramGroups.values.joinToString("\n")}")

    return anagramGroups.values.toList()
}


