class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        // heap sort - nlogk , soring nlogn
        // below is qs - n-n2

        return findByQs(nums, k, 0, nums.size - 1)

    }

    fun findByQs(nums: IntArray, k: Int, s:Int, e:Int): Int {
        val p = partition(nums, s, e)
        if (p == nums.size - k) {
            return nums[p]
        } else if (p > nums.size - k) {
            return findByQs(nums, k , s, p-1)
        } else {
            return findByQs(nums, k , p+1 , e)
        }
    }

    fun partition(nums: IntArray, s:Int, e:Int) :Int {
        if(s == e) {
            return s
        }
        val random = (s..e).random()
        nums[s] = nums[random].also {
            nums[random] = nums[s]
        }

        var l = s + 1
        var r = e
        while(l <= r) {
            while (l <= e && nums[l] <= nums[s]) { l++ }
            while (r > s && nums[r] > nums[s]) { r-- }

            if(l < r) {
                nums[l] = nums[r].also {
                    nums[r] = nums[l]
                }
                l++
                r--
            }

        }
        nums[l-1] = nums[s].also {
            nums[s] = nums[l-1]
        }
        
        return l - 1
    }
}
