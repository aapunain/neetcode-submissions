class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        nums.sort()

        for(idx in 0 until nums.size - 1) {
            if(nums[idx] == nums[idx+1]) {
                return true
            }
        }

        return false
    }
}
