class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        // no can be between 1 and nums.size + 1 only

        // - sort (nlogn) , with extra space (o.n ) - time O.n , if use input as extra splace then O.n


        for (i in nums.indices) {
            if(nums[i] < 0) {
                nums[i] = 0
            }
        }

        for (i in nums.indices) {
            if(nums[i] == 0 || abs(nums[i]) > nums.size) {
                continue
            }
            val index = abs(nums[i]) - 1
            nums[index] = if(nums[index] == 0)
                                -abs(nums[i]) 
                            else 
                                -abs(nums[index])
        }

        for (i in nums.indices) {
            if(nums[i] >=0) {
                return i + 1
            }
        }

        return nums.size + 1


    }
}
