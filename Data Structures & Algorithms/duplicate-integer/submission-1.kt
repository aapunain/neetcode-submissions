class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        nums.sort()

        // for(idx in 0 until nums.size - 1) {
            // if(nums[idx] == nums[idx+1]) {
                // return true
            // }
        // }

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
