class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        
        for (r in 0..8) {
            val seen = HashSet<Char>()
            for (c in 0..8) {
                if (board[r][c] == '.') {
                    continue
                }
                 if (seen.contains(board[r][c])) {
                    return false
                }
                seen.add(board[r][c])
            }
        }

        for (c in 0..8) {
            val seen = HashSet<Char>()
            for (r in 0..8) {
                if (board[r][c] == '.') {
                    continue
                }
                 if (seen.contains(board[r][c])) {
                    return false
                }
                seen.add(board[r][c])
            }
        }

        for(sq in 0..8) {
             val seen = HashSet<Char>()
            for(r in 0..2) {
                for(c in 0..2) {
                    val ar = r + (sq/3) *3
                    val ac = c + (sq%3) *3 
                    if (board[ar][ac] == '.') {
                       continue
                     }
                     if (seen.contains(board[ar][ac])) {
                        return false
                     }
                     seen.add(board[ar][ac])
                 }
            }
        }
        return true
    }
   
}
