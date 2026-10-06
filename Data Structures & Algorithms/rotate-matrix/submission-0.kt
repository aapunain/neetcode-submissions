class Solution {
    fun rotate(matrix: Array<IntArray>) {
        if(matrix.size <= 1){
            return 
        }
        
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
    }
}
