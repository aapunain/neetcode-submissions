class Solution {
    fun search(nums: IntArray, target: Int): Int {
        /*
        var l = 0
        var r = nums.size - 1

        while(l <= r) {
            val mid = l + (r-l)/2
            when {
                nums[mid] == target -> return mid
                nums[mid] > target -> r = mid - 1
                nums[mid] < target -> l = mid + 1
            }
        }

        return -1
        */

        // lower bound

        var l = 0
        var r = nums.size

        while(l < r) {
            val mid = l + (r-l)/2
            when {
                nums[mid] < target -> l = mid + 1
                nums[mid] > target -> r = mid
                nums[mid] == target -> r = mid
            }
        }
        return if (l < nums.size && nums[l] == target) l else -1
    }
}
