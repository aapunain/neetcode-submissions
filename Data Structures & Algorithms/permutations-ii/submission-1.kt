class Solution {
    // check sol 1 also
    val res = mutableListOf<List<Int>>()
    val currentList = mutableListOf<Int>()
    val countMap = mutableMapOf<Int, Int>()

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        for(num in nums) {
            countMap[num] = countMap.getOrElse(num) {
                0
            } + 1
        }
        permuteInternal(nums)
        return res
    }

    fun permuteInternal(nums:IntArray) {
        if (currentList.size == nums.size) {
            res.add(currentList.toList())
            return
        }

        for(k in countMap.keys) {
            if(countMap[k]!! > 0) {
                countMap[k] = countMap[k]!! - 1
                currentList.add(k)
                permuteInternal(nums)
                currentList.removeLast()
                countMap[k] = countMap[k]!! + 1
            }
        }
    }
}
