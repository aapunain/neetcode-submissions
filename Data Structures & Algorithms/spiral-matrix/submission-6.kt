class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        
        val res = mutableListOf<Int>()
/*    
        val m = matrix.size - 1
        val n = matrix[0].size - 1

        for (i in 0..(minOf(m,n)/2)) {
            val endRow = m - i
            val endCol = n - i

            
            for (col in i..endCol) {
                res.add(matrix[i][col])
            }

            if(endRow == i) {
                continue
            }


            for (row in (i+1)..endRow) {
                res.add(matrix[row][endCol])
            }

            if (endCol == i) {
                continue
            }

            for (col in (endCol-1) downTo i) {
                res.add(matrix[endRow][col])
            }

            for (row in (endRow-1) downTo (i+1)) {
                res.add(matrix[row][i])
            }

        }
*/
        // solution 2 - perfect simple and thoughful

        var left = 0
        var top = 0
        var bottom = matrix.size - 1
        var right = matrix[0].size - 1

        while (left <= right && top <= bottom) {
            for (i in left..right) {
                res.add(matrix[top][i])
            }
            top++

            if (!(top <= bottom)) break

            for (i in top..bottom) {
                res.add(matrix[i][right])
            }
            right--

            if (!(left <= right)) break

            for (i in right downTo left) {
                res.add(matrix[bottom][i])
            }
            bottom--

            for (i in bottom downTo top) {
                res.add(matrix[i][left])
            }
            left++
        }

        return res
    }
}
