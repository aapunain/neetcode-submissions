class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        
        if(nums.size == 0) {
            return intArrayOf(-1, -1)
        }

        var l = 0
        var r = nums.size
        while(l < r) {
            val mid = l + (r-l)/2
            if(nums[mid] < target) {
                l = mid + 1
            } else {
                r = mid
            }
        }

     
        var left = l
        if(l < nums.size && nums[l] == target) {
            left = l
        } else {
            return intArrayOf(-1, -1)
        }


        l = 0
        r = nums.size
        while(l < r) {
            val mid = l + (r-l)/2

            if(nums[mid] <= target) {
                l = mid + 1
            } else {
                r = mid
            }
        }

        var right = -1
        if(l >= 0 && nums[l-1] == target) {
            right = l-1
        }
        return intArrayOf(left, right)
    }
}
