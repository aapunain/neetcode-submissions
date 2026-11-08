class Solution {

    val currentSubSet = mutableListOf<Int>()
    val res = mutableListOf<List<Int>>()

    fun subsets(nums: IntArray): List<List<Int>> {
        dfs(nums, 0)
        return res
    }

    fun dfs(nums:IntArray, pos:Int) {
        if(pos >= nums.size) {
            res.add(currentSubSet.toList())
            return
        }
        currentSubSet.add(nums[pos])
        dfs(nums, pos + 1)
        currentSubSet.removeLast()
        dfs(nums, pos + 1)
    }


}
