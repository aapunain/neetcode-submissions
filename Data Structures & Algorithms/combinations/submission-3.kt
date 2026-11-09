class Solution {

    val res = mutableListOf<List<Int>>()
    val currentList = mutableListOf<Int>()

    fun combine(n: Int, k: Int): List<List<Int>> {
        combineInternal(n, k, 1)
        return res
    }

    fun combineInternal (n:Int, k:Int, no:Int) {
        if(k == currentList.size) {
            res.add(currentList.toList())
            return
        }

        if(no > n || currentList.size + (n - no + 1) < k) { // just for performance
            return
        }

        for(i in no..n) {
            currentList.add(i)
            combineInternal(n, k, i + 1)
            currentList.removeLast()
        }
    }
}
