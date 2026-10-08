class Solution {
    fun findMin(nums: IntArray): Int {

        if(nums.size == 1) {
            return nums[0]
        }

        var l = 0
        var r = nums.size - 1
        val size = nums.size - 1



        while(l < r) {
            val mid = l + (r - l) / 2

            if(mid == l) {
                return minOf(nums[l], nums[r])
            }
            
            when {
                nums[mid] < nums[r] && 
                nums[mid] > nums[l] -> {
                    r = mid
                }

                nums[mid] < nums[r] && 
                nums[mid] < nums[l] -> {
                    r = mid
                }

                nums[mid] > nums[r] && 
                nums[mid] > nums[l] -> {
                    l = mid
                }
            }
        }
        
        throw RuntimeException("tttt")

    }
}
