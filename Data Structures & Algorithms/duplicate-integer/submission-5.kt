class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {

/*
        val sorted = nums.sorted()

        for(idx in 0 until sorted.size - 1) {
            if(sorted[idx] == sorted[idx+1]) {
                return true
            }
        }
*/

val hashSet = mutableSetOf<Int>()
        nums.forEach {
            if (hashSet.contains(it)) return true
            hashSet.add(it)
        }
        return false

        return false
    }
}
