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
/*
        val n = matrix.size - 1

        for(i in 0..n/2) {
            val t = matrix[i]
            matrix[i] = matrix[n-i]
            matrix[n-i] = t
        }

        for (i in 0..n) {
            for (j in 0..i) {
                val t = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = t
            }
        }
        */

        // rotate one layer at a time - like surface of onion

        var low = 0
        var high = matrix.size - 1
        val n = matrix.size - 1
        while(low < high) {
            for (i in low until high) {

               val topLeft = matrix[low][i] // top left

               matrix[low][i] = matrix[n-i][low] // top left <= bottom left

               matrix[n-i][low] = matrix[high][n-i] // bottom left <= bottom right

               matrix[high][n-i] = matrix[i][high] // bottom right <= top right

               matrix[i][high] = topLeft // top right <= top left

            }
            low++
            high--
        }
    }
}
