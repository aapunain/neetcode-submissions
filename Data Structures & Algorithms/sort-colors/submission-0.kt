class Solution {



    fun sortColors(nums: IntArray) {
        var s = 0 
        var e = nums.size - 1
        var i = 0
        while(i < nums.size) {
            if(nums[i] == 0) {
                if(s != i) {
                    nums.swap(s, i)
                    s++
                } else {
                    s++
                    i++
                }
            } else if (nums[i] == 2) {
                if(e > i) {
                    nums.swap(e, i)
                    e--
                } else {
                    break
                }
            } else if (nums[i] == 1) {
                i++
            }
        }
    }

    fun IntArray.swap(a:Int, b:Int) {
        this[a] = this[b].also {
            this[b] = this[a]
        }
    }
}
