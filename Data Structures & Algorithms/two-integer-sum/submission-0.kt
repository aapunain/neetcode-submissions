class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // brute force - n2, 1

        // sorted - nlogn, n

        // hashmap - n, n

        val map = mutableMapOf<Int, Int>()

        nums.forEachIndexed { idx, num ->
            if(map.contains(target - num)) {
                return intArrayOf(map.get(target - num)!!, idx)
            }
            map[num] = idx
        }

        return intArrayOf()
    }
}
