class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        
        if(s.length != t.length) return false

        val freqArray = IntArray(26)

        for (idx in 0 until s.length) {
            freqArray[s[idx] - 'a']++
            freqArray[t[idx] - 'a']--
        }
    

        for (f in freqArray) {
            if(f != 0) return false
        }

        return true

    }
}
