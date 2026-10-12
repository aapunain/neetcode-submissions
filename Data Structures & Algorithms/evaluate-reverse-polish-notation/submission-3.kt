class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Long>()
        tokens.forEach{ 
            when(it) {
                "+", "-", "*", "/" -> {
                    val op1 = stack.removeLast()
                    val op2 = stack.removeLast()
                    val res = when (it) {
                        "+" -> op2 + op1
                        "-" -> op2 - op1
                        "*" -> op2 * op1
                        "/" -> op2 / op1
                        else -> throw RuntimeException("nhi ayega")
                    }
                    stack.addLast(res)
                }
                else -> stack.addLast(it.toLong())
            }
        }
        return stack.removeLast().toInt()
    }
}
