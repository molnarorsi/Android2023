package main

import kotlin.random.Random

class TextGenerator(private val originalText: String) {
    private val wordPairs: List<Pair<String, String>> by lazy {
        originalText.split(" ").zipWithNext()
    }

    fun learnWords(): Map<Pair<String, String>, MutableList<String>> {
        val wordMap = mutableMapOf<Pair<String, String>, MutableList<String>>()

        for (i in 0 until wordPairs.size - 2) {
            val key = Pair(wordPairs[i].first, wordPairs[i].second)
            val postfix = wordPairs[i + 2].first
            wordMap.getOrPut(key) { mutableListOf() }.add(postfix)
        }

        return wordMap
    }

    fun generateText(wordMap: Map<Pair<String, String>, MutableList<String>>): List<String> {
        val generatedText = mutableListOf(originalText)
        var currentPair = Pair(wordPairs[0].first, wordPairs[0].second)

        while (wordMap.containsKey(currentPair)) {
            val postfixOptions = wordMap[currentPair]!!
            val nextWord = if (postfixOptions.isNotEmpty()) {
                postfixOptions[Random.nextInt(postfixOptions.size)]
            } else {
                break
            }

            generatedText.add("$currentPair $nextWord")
            currentPair = Pair(currentPair.second, nextWord)
        }

        return generatedText
    }
}
