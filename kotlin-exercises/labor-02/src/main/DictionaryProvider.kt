class DictionaryProvider {
    fun createDictionary(type: DictionaryType) : IDictionary {
        return when(type) {
            DictionaryType.ARRAY_LIST -> ListDictionary
            else -> {
                ListDictionary
            }
        }
    }
}