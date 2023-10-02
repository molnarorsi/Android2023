import java.io.File
import java.util.TreeSet

object TreeSetDictionary : IDictionary {
    private var words = TreeSet<String>()

    init {
        File(IDictionary.DICTIONARY_NAME).forEachLine { add (it) }
    }

    override fun add(word: String): Boolean {
        if(words.contains(word)) {
            return false
        }
        words.add(word)
        return true
    }

    override fun find(word: String): Boolean {
        return words.contains(word)
    }

    override fun size(): Int {
        return words.size
    }
}