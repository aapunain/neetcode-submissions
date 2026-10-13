class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {

        val freq = IntArray(26)
        s1.forEach {
            freq[it - 'a'] = freq[it - 'a'] + 1
        }

        var ws = 0
        val freqCheck = IntArray(26)
        var we = 0
        while (we <= s2.length ) {
            if(we - ws == s1.length) {
                return true
            }

            if(we == s2.length) {
                return false
            }

            val char = s2[we] - 'a'
            
            if(freqCheck[char] < freq[char]) {
                freqCheck[char] = freqCheck[char] + 1
                we++
            } else {
                if(ws < we ) {
                    freqCheck[s2[ws] - 'a'] = freqCheck[s2[ws] - 'a'] - 1
                    ws++
                } else {
                    ws++
                    we++
                }
            }
        }

        return false

    }
}
