class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        val map = mutableMapOf<String, MutableList<String>>()

        
        strs.forEach {str ->
            val sortedStr = str.toCharArray().sorted().joinToString("")
            map.getOrPut(sortedStr) { mutableListOf()}.add(str)
        }

        return map.values.toList()
    }
}
