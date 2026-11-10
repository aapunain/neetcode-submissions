class Solution {
    // concept is correct .. for impvements check solution - about using hashset
    var res = 0

    fun totalNQueens(n: Int): Int {
        val placement = Array<CharArray>(n) {
            CharArray(n) {'.'}
        }

        selectPlacementInRow(n, 0, placement)

        return res

    }

    fun selectPlacementInRow(n:Int, r:Int, placement: Array<CharArray> ) {
        if(r == n) {
            res++
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

        // for(c in 0..n-1) { not needed
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

        while(r >= 0 && c < n) {
            if(placement[r][c] == 'Q') {
                return false
            }
            r--
            c++
        }
        return true

    }
}
