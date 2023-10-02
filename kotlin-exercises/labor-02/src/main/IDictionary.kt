interface IDictionary {
    companion object {
        const val DICTIONARY_NAME = "D:\\UNIVERSITY\\Negyedev\\Elso felev\\Android2023\\kotlin-exercises\\labor-02\\src\\resources\\dictionary.txt"
    }

    fun add(word: String) : Boolean
    fun find(word: String) : Boolean
    fun size() : Int
}