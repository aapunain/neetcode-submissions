class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        // return viaSorting(nums)
        return viaSet(nums)
    }

    fun viaSet(nums: IntArray): Int {
        val set = nums.toSet()
        
        var max = 0
        for (n in nums) {
            var l = 0
            var c = n
            if(n-1 !in set) {
                while(c in set) {
                    c++
                    l++
                }
                max = maxOf(max, l)
            }
        }
        return max
    }

    fun viaSorting(nums: IntArray): Int {
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
