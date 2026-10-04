class Solution {
    fun isPalindrome(s: String): Boolean {
        if(s.length == 0 || s.length == 1) {
            return true
        }
        var start = 0
        var end = s.length - 1

        while(start < end) {
            if(!s[start].isLetterOrDigit()) {
                start++ 
                continue
            }
            if(!s[end].isLetterOrDigit()) {
                end--
                continue
            }
            if(s[start].lowercaseChar() != s[end].lowercaseChar()) {
                return false
            }
            start++
            end--
        } 
        return true

    }
}
