class Solution {
    fun search(nums: IntArray, target: Int): Int {

        // first find min in this array 

        var l = 0
        var r = nums.size - 1

        while(l <= r) {
            val mid = l + (r-l)/2
            
            if(target == nums[mid]) {
                return mid
            }

            if(nums[mid] < nums[r] ) {
                if(target > nums[mid]) {
                    if(target <= nums[r]) {
                        l = mid + 1
                    } else {
                        r = mid -1
                    }
                } else {
                    r = mid - 1
                }
            } else {
                if(target < nums[mid] && target >= nums[l]) {
                    r = mid - 1
                } else {
                    l = mid + 1 
                }
            }
        }

        return -1

    }
}
