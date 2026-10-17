class Solution {
    fun check(nums: IntArray): Boolean {
        // can check last solution
        if(nums.size <=2) return true

        var i = 1
        while (i < nums.size && nums[i] >= nums[i - 1]) {
            i++
        }

        if (i >= nums.size){
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