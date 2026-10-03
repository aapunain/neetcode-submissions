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

        val seen = HashSet<Int>()
        for (num in nums) {
            if (num in seen) {
                return true
            }
            seen.add(num)
        }

        return false
    }
}
