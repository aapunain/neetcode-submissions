class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        val m = matrix.size
        val n = matrix[0].size 

        var l = 0
        var r = m*n - 1

        while(l <= r) {
            val mid = l + (r-l) / 2

            val i = mid / n
            val j = mid % n

            when {
                matrix[i][j] == target -> return true
                matrix[i][j] < target -> l = mid + 1
                matrix[i][j] > target -> r = mid - 1
            }
        }

        return false

    }
}
