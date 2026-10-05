class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var s = 0
        var e = numbers.size - 1

        while (s < e) {
            when {
                numbers[s] + numbers[e] == target -> return intArrayOf(s+1, e+1)
                numbers[s] + numbers[e] < target -> s++
                numbers[s] + numbers[e] > target -> e--
            }
        }
        return intArrayOf()
    }
}
