class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {

        val visited = Array<BooleanArray> (board.size) { BooleanArray(board[0].size) }
        
        for(r in board.indices) {
            for (c in board[0].indices) {
                if (existInternal(board, word, visited, r, c)) {
                    return true
                }
            }
        }

        return false

    }

    fun existInternal(board: Array<CharArray>, pendingWord: String, visited: Array<BooleanArray> , r:Int, c:Int): Boolean {
            if (pendingWord.isEmpty()) {
                return true
            }
            
            if(r < 0 || c < 0 || r >= board.size || c >= board[0].size) {
                return false
            }

            if(visited[r][c]) {
                return false
            }

            if(board[r][c] != pendingWord[0]) {
                return false
            }

            visited[r][c] = true
            val pWord = pendingWord.substring(1, pendingWord.length)

            if(existInternal(board, pWord, visited, r , c+1)
            || existInternal(board, pWord, visited, r+1 , c)
            || existInternal(board, pWord, visited, r-1 , c)
            || existInternal(board, pWord, visited, r , c-1)) {
                return true
            }
            visited[r][c] = false
            return false
    }

}
