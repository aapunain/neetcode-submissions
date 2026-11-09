class Solution {
    val res = mutableListOf<List<String>>()

    fun solveNQueens(n: Int): List<List<String>> {
        val placement = Array<BooleanArray>(n) {
            BooleanArray(n)
        }

        selectPlacementInRow(n, 0, placement)

        return res

    }

    fun selectPlacementInRow(n:Int, r:Int, placement: Array<BooleanArray> ) {
        if(r == n) {
            addPlacementInRes(placement).also {
                res.add(it)
            }
        }

        for(c in 0..n-1) {
            if (canPlace(n, r, c, placement)) {
                placement[r][c] = true
                selectPlacementInRow(n, r+1, placement)
                placement[r][c] = false
            }
        }
    }

    fun canPlace(n:Int, row:Int, col:Int, placement: Array<BooleanArray>) :Boolean {
        for(r in 0..n-1) {
            if(placement[r][col]) {
                return false
            }
        }

        for(c in 0..n-1) {
            if(placement[row][c]) {
                return false
            }
        }

        var r = row
        var c = col
        while(r>=0 && c>= 0) {
            if(placement[r][c]) {
                return false
            }
            r--
            c--
        }

        r = row
        c = col

        while(r>=0 && c < n) {
            if(placement[r][c]) {
                return false
            }
            r--
            c++
        }
        return true

    }

    fun addPlacementInRes(placement: Array<BooleanArray>) : List<String>{
        return placement.map { barr ->
            val sb = StringBuilder()
            barr.forEach {
                sb.append(if (it) "Q" else ".")
            }
            sb.toString()
        }
    }
}
