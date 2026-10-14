class Solution {
    fun plusOne(digits: IntArray): IntArray {
        for (i in (digits.size - 1) downTo 0) {
            if(digits[i] < 9) {
                digits[i]++
                return digits
            } else {
                digits[i] = 0
            }
        }

        return intArrayOf(1) + digits
    }
}
