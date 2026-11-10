class Solution {
    val res = mutableListOf<List<Int>>()
    val currentSet = mutableListOf<Int>()

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {

        nums.sort()

        bt(nums, 0)

        return res

    }

    fun bt(nums: IntArray, idx: Int) {
        if(idx == nums.size) {
            res.add(currentSet.toList())
            return
        }

        var count = 0
        for(i in idx until nums.size) {
            if(nums[idx] == nums[i]) {
                count++
            } else {
                break
            }
        }

        for(i in 0..count) {
            for(c in 1..i) {
                currentSet.add(nums[idx])
            }
            bt(nums, idx + count)
            for(c in 1..i) {
                currentSet.removeLast()
            }
        }
    }

}
