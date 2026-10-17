class Solution {
    fun prefixCount(words: Array<String>, pref: String): Int {

        var res = 0

        for(w in words) {
            if(w.length < pref.length) continue
            var i = 0
            while (i < pref.length) {
                if(w[i] != pref[i]){
                    break
                }
                i++
            }
            if( i == pref.length)  {
                res++
            }
        }
        return res

    }
}
