class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.length <=1) {
            return s.length
        }
         var max = 0
/*
        val freq = HashSet<Char>()
        
        var start = 0
        var end = 0

        while (end < s.length) {
            while (freq.contains(s[end])) {
                freq.remove(s[start++])
            }
            if(max < (end-start+1)) {
                max = end-start+1
            }
            freq.add(s[end])
            end++
        }
*/
        val windowIndex = HashMap<Char, Int>()
        
        var start = 0
        var end = 0

        while (end < s.length) {
            if (windowIndex.contains(s[end]) && windowIndex.get(s[end])!! >= start) {
                start = windowIndex.get(s[end])!! + 1
            }

            if(max < (end-start+1)) {
                max = end-start+1
            }
            windowIndex[s[end]] = end
            end++
        }


        return max
    }
}
