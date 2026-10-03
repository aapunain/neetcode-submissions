class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        
        if(s.length != t.length) return false

        val freqArray = IntArray(26)

        for (c in s) {
            freqArray[c - 'a']++
        }
        for (c in t) {
            freqArray[c - 'a']--
        }

        for (f in freqArray) {
            if(f != 0) return false
        }

        return true

    }
}
