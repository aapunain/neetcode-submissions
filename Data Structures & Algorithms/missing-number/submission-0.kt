class Solution {
    fun missingNumber(nums: IntArray): Int {
        var res = 0
        for( i in nums.indices){
            res += i
            res -= nums[i]
        }
        res += nums.size

        return res
    }
}
