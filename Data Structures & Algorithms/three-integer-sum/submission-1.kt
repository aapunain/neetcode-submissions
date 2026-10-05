class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {

        nums.sort()

        val res = mutableListOf<List<Int>>()

        var start = 0
        
        while(start < nums.size -2) {

            var l = start + 1
            var r = nums.size - 1

            while (l < r) {
                when {
                    nums[start] + nums[l] + nums[r] > 0 -> r--
                    nums[start] + nums[l] + nums[r] < 0 -> l++
                    nums[start] + nums[l] + nums[r] == 0 -> {
                        res.add(listOf(nums[start], nums[l], nums[r]))
                        l++
                        r--
                        while(l < r && nums[l] == nums[l-1]) {
                            l++
                        }
                    }
                }
            }

            while(start < nums.size -2 && nums[start] == nums[++start]) {
            }
        }

        return res

    }
}
