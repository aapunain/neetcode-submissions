class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {

/*
        val map = mutableMapOf<String, MutableList<String>>()
        strs.forEach {str ->
            val sortedStr = str.toCharArray().sorted().joinToString("")
            map.getOrPut(sortedStr) { mutableListOf()}.add(str)
        }
*/

        val map = mutableMapOf<List<Int>, MutableList<String>>()

        strs.forEach {
            val freq = MutableList(26) { 0 }

            for (c in it) {
                freq[c - 'a']++
            }

            map.getOrPut(freq) {mutableListOf()}.add(it)

        }

        return map.values.toList()
    }
}
