class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if(nums.size < 2) {
            return nums.size
        }

        nums.sort()

        var res = 1
        var i = 1
        while (i < nums.size) {
            var c = 1
            while (i < nums.size && nums[i] - nums[i-1] <= 1) {
                if(nums[i] - nums[i-1] == 1) {
                    c++
                }
                i++
            }
            res = maxOf(res, c)
            i++
        }

        return res

    }
}
