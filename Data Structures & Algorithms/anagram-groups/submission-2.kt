class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        val sorted = strs.map {
            it.toCharArray().sorted().toString()
        }

        // val sorted = strs.map {
            // it.toCharArray().apply {
                // sort()
            // }.contentToString()
        // }

        val map = mutableMapOf<String, MutableList<String>>()

        sorted.forEachIndexed {idx, str ->
            val list = map[str] ?: mutableListOf<String>()
            list.add(strs[idx])
            map[str] = list
        }



        return map.map{
            it.value
        }
    }
}
