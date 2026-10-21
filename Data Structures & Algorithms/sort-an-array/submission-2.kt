class Solution {
    fun sortArray(nums: IntArray): IntArray {
        //return quickSort(nums)
        return mergeSort(nums)
    }

    fun mergeSort(nums: IntArray): IntArray {
        ms(nums, 0 , nums.size - 1)
        return nums
    }

    fun ms(nums: IntArray, l: Int , r: Int) {
        if ( l >= r ){
            return
        }
        val m = l + (r - l) / 2
        ms(nums, l, m)
        ms(nums, m + 1, r)
        merge(nums, l , m , r)
    }

    fun merge(nums: IntArray, l: Int , m: Int, r: Int) {
        val a1 = nums.copyOfRange(l, m+1) // can pass some temp array
        val a2 = nums.copyOfRange(m+1, r+1)

        var k = l
        var i = 0
        var j = 0

        while(i < a1.size && j < a2.size) {
            nums[k++] = if(a1[i] <= a2[j]) a1[i++] else a2[j++]
        }

        while(i < a1.size) {
            nums[k++] = a1[i++] 
        }

        while(j < a2.size) {
            nums[k++] = a2[j++] 
        }

    }

    // .......................................................................................

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
            while (nums[j] > pivot) { j-- }
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
