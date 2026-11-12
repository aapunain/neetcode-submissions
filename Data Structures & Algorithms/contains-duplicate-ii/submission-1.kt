class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if(map.contains(nums[i])) {
                if(i - map[nums[i]]!! <= k) {
                    return true
                }
            }
            map[nums[i]] = i
        }

        return false
    }
}
