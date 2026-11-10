class Solution {

    val res = mutableListOf<List<Int>>()
    val currentList = mutableListOf<Int>()

    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        cSumInternal(nums, target, 0)
        return res
    }

    fun cSumInternal(nums: IntArray, target: Int, idx: Int) {
        if(target == 0) {
            res.add(currentList.toList())
            return
        }

        if(target < 0 || idx >= nums.size ) {
            return
        }
     
        for (freq in 0..(target / nums[idx])) {
            for (i in 1..freq) {
                currentList.add(nums[idx])
            }
          
            cSumInternal(nums, target - freq * nums[idx] , idx + 1)

            for (i in 1..freq) {
                currentList.removeLast()
            }
        }
    }
}
