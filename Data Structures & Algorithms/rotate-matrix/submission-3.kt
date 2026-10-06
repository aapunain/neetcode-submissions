class Solution {
    fun rotate(matrix: Array<IntArray>) {
        if(matrix.size <= 1){
            return 
        }
        
        /* brute force
        val rotated = Array<IntArray>(matrix.size) {
            IntArray(matrix.size)
        }

        val n = matrix.size - 1

        for (r in 0..n) {
            for (i in 0..n){
                rotated[i][n - r] = matrix[r][i]
            }
        }

        for (r in 0..n) {
            for (c in 0..n){
                matrix[r][c] = rotated[r][c]
            }
        }
        */

        val n = matrix.size - 1

        for(i in 0..n/2) {
            for(j in 0..n) {
                val t = matrix[i][j]
                matrix[i][j] = matrix[n-i][j]
                matrix[n-i][j] = t
            }
        }

        for (i in 0..n) {
            for (j in 0..i) {
                val t = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = t
            }
        }
        
    }
}
