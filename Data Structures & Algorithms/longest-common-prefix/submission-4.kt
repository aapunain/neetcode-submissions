class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {  
        // trie is over engineering for it
        if(strs.isEmpty()) {
            return ""
        }

        var res = ""

        for(i in 0..(strs[0].length - 1)) {
            for (s in strs) {
                if(i > s.length - 1 || s[i] != strs[0][i]) {
                    return res
                }
            }
            res = res + strs[0][i]
        }

        return res

    }
}
