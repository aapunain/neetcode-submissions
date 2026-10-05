class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.length <=1) {
            return s.length
        }

        val freq = HashSet<Char>()

        var max = 0
        
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

        return max
    }
}
