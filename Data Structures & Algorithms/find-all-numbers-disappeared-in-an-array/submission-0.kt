class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val n = nums.size

        for(i in nums.indices) {
            var no = nums[i]
            while (no != -1) {
                no = nums[no - 1].also {
                    nums[no - 1] = -1 
                }
            }
        }

        val list = mutableListOf<Int>()
        for(i in nums.indices) {
            if(nums[i] != -1) {
                list.add(i+1)
            }
        }

        return list

    }
}
