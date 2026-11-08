class Solution {


    val res = mutableListOf<List<Int>>()
    lateinit var visited: BooleanArray

    val currentPermute = mutableListOf<Int>()

    fun permute(nums: IntArray): List<List<Int>> {
        visited = BooleanArray(nums.size) {
            false
        }
        permuteInternal(nums)
        return res
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
