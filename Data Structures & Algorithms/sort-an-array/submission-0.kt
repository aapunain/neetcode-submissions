class Solution {
    fun sortArray(nums: IntArray): IntArray {
        return quickSort(nums)

    }

    fun quickSort(nums: IntArray): IntArray {
        qs(nums, 0 , nums.size - 1)
        return nums
    }

    fun qs(nums: IntArray, l:Int, r:Int) {
        if(l >= r) {
            return
        }

        val p = partition(nums, l , r)
        qs(nums, l, p - 1)
        qs(nums, p + 1 , r)
    }

    fun partition(nums: IntArray, l: Int, r: Int) : Int {
        val random = (l..r).random()

        nums[l] = nums[random].also{ nums[random] = nums[l]} // swap

        val pivot = nums[l]
        var i = l + 1
        var j = r

        while(i <= j) {
            while (i <= r && nums[i] <= pivot) { i++ }
            while (j >= l && nums[j] > pivot) { j-- }
            if (i < j) {
                nums[i] = nums[j].also {
                    nums[j] = nums[i]
                }
            }
        }

        nums[j] = nums[l].also {nums[l] = nums[j]}

        return j

    }
}
