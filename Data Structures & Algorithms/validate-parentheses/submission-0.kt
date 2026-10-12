class Solution {
    fun isValid(s: String): Boolean {
        val compChar = mapOf(')' to '(', 
                             '}' to '{',
                             ']' to '['
                            )
        val stack = ArrayDeque<Char>()

        s.forEach {
            when(it) {
                '(', '{', '[' -> stack.addLast(it)
                else -> {
                    if(stack.isEmpty()) {
                        return false
                    }
                    val char = stack.removeLast()
                    if(char != compChar[it]) {
                        return false
                    }
                }
            }
        }

        return stack.isEmpty()

    }
}
