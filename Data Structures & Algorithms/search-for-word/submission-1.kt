class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {

        val visited = Array<BooleanArray> (board.size) { BooleanArray(board[0].size) }
        
        for(r in board.indices) {
            for (c in board[0].indices) {
                if (existInternal(board, word, 0, visited, r, c)) {
                    return true
                }
            }
        }

        return false

    }

    fun existInternal(board: Array<CharArray>, word: String, index:Int, visited: Array<BooleanArray> , r:Int, c:Int): Boolean {
            if (word.length == index) {
                return true
            }
            
            if(r < 0 || c < 0 || r >= board.size || c >= board[0].size) {
                return false
            }

            if(visited[r][c]) {
                return false
            }

            if(board[r][c] != word[index]) {
                return false
            }

            visited[r][c] = true

            if(existInternal(board, word, index + 1, visited, r , c+1)
            || existInternal(board, word, index + 1, visited, r+1 , c)
            || existInternal(board, word, index + 1, visited, r-1 , c)
            || existInternal(board, word, index + 1, visited, r , c-1)) {
                return true
            }
            visited[r][c] = false
            return false
    }

}
