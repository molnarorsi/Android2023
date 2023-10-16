package main

data class Item(val question: String, val answers: List<Pair<Int, String>>, val correct: Int) {
    override fun equals(other: Any?): Boolean {
        if(this === other) {
            return true
        }
        if(other !is Item) {
            return false
        }

        return question == other.question
    }

    override fun hashCode(): Int {
        var result = question.hashCode()
        result = 31 * result + answers.hashCode()
        result = 31 * result + correct
        return result
    }
}
