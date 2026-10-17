class Solution {
    fun check(nums: IntArray): Boolean {
        if(nums.size <=2) return true
        
        var fi = 0
        var i = 1
        while (i < nums.size && nums[i] >= nums[i - 1]) {
            i++
        }

        if(i >= nums.size){
            return true
        }

        if(nums[i] > nums[0]) {
            return false
        }
        i++

        while(i < nums.size) {
            if(nums[i] < nums[i-1] || nums[i] > nums[0]) {
                return false
            }
            i++
        }

        return true

    }
}