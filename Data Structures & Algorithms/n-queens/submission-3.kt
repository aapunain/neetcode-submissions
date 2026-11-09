class Solution {
    // concept is correct .. for impvements check solution
    val res = mutableListOf<List<String>>()

    fun solveNQueens(n: Int): List<List<String>> {
        val placement = Array<CharArray>(n) {
            CharArray(n) {'.'}
        }

        selectPlacementInRow(n, 0, placement)

        return res

    }

    fun selectPlacementInRow(n:Int, r:Int, placement: Array<CharArray> ) {
        if(r == n) {
            addPlacementInRes(placement).also {
                res.add(it)
            }
        }

        for(c in 0..n-1) {
            if (canPlace(n, r, c, placement)) {
                placement[r][c] = 'Q'
                selectPlacementInRow(n, r+1, placement)
                placement[r][c] = '.'
            }
        }
    }

    fun canPlace(n:Int, row:Int, col:Int, placement: Array<CharArray>) :Boolean {
        for(r in 0..n-1) {
            if(placement[r][col] == 'Q') {
                return false
            }
        }

        // for(c in 0..n-1) {
        //     if(placement[row][c] == 'Q') {
        //         return false
        //     }
        // }

        var r = row
        var c = col
        while(r>=0 && c>= 0) {
            if(placement[r][c] == 'Q') {
                return false
            }
            r--
            c--
        }

        r = row
        c = col

        while(r>=0 && c < n) {
            if(placement[r][c] == 'Q') {
                return false
            }
            r--
            c++
        }
        return true

    }

    fun addPlacementInRes(placement: Array<CharArray>) : List<String>{
        return placement.map { carr ->
            carr.joinToString("")
        }
    }
}
