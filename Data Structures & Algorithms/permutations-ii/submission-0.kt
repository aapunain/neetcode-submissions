class Solution {

    val res = mutableSetOf<List<Int>>()
    lateinit var visited: BooleanArray

    val currentPermute = mutableListOf<Int>()

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        visited = BooleanArray(nums.size) {
            false
        }
        permuteInternal(nums)
        return res.toList()
    }

    fun permuteInternal(nums:IntArray) {
        if(currentPermute.size == nums.size) {
            res.add(currentPermute.toList())
            return
        }
  
        for (i in nums.indices) {
            if(!visited[i]) {
                visited[i] = true
                currentPermute.add(nums[i])
                permuteInternal(nums)
                visited[i] = false
                currentPermute.removeLast()
            } 
        }
    }
}
