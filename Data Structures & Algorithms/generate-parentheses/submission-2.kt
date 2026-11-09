class Solution {
    val res = mutableListOf<String>()
    val tracker = StringBuilder()
    fun generateParenthesis(n: Int): List<String> {
        parenthesis(n, 0, 0)
        return res
    }

    fun parenthesis(n:Int, currentOpen:Int, currentClose: Int) {
        if(currentOpen > n || currentClose > n) {
            return
        } 

        if(currentOpen == n && currentClose == n) {
            res.add(tracker.toString())
        }

        if (currentOpen < currentClose) {
            return
        }

        if (currentOpen >= currentClose) {
            tracker.append("(")
            parenthesis(n, currentOpen + 1, currentClose)
            tracker.deleteCharAt(tracker.length - 1)

            tracker.append(")")
            parenthesis(n, currentOpen, currentClose + 1)
            tracker.deleteCharAt(tracker.length - 1)
        }
    }
}
