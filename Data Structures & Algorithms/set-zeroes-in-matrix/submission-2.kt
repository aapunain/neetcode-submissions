class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        var has0InRow1 = false
        var has0InCol1 = false
        for(r in 0..matrix.size-1) {
            for(c in 0.. matrix[r].size-1) {
                if(matrix[r][c] == 0) {
                    matrix[r][0] = 0
                    matrix[0][c] = 0

                    if(r == 0) {
                        has0InRow1 = true
                    }
                    if(c == 0) {
                        has0InCol1 = true
                    }
                }
            }
        }

        for(r in 1..matrix.size-1) {
            if(matrix[r][0] == 0) {
                for(c in 0.. matrix[r].size-1) {
                    matrix[r][c] = 0
                }
            }
        }

        for(c in 1..matrix[0].size-1) {
            if(matrix[0][c] == 0) {
                for(r in 0.. matrix.size-1) {
                    matrix[r][c] = 0
                }
            }
        }

        if(has0InRow1) {
            for(c in 0.. matrix[0].size-1) {
                    matrix[0][c] = 0
                }
        }

        if(has0InCol1) {
            for(r in 0.. matrix.size-1) {
                    matrix[r][0] = 0
                }
        }
    }
}
