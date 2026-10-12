class MinStack() {

    val stack = ArrayDeque<Pair<Int, Int>>()

    fun push(`val`: Int) {
        if (stack.isEmpty()) {
            stack.addLast(Pair(
                `val`, `val` 
            ))
        } else {
            stack.addLast(Pair(
                `val`, minOf(stack.last.second, `val`)
            ))
        }
    }

    fun pop() {
        stack.removeLast()
    }

    fun top(): Int {
        return stack.last()?.first ?: 0
    }

    fun getMin(): Int {
        return stack.last()?.second ?: 0
    }
}
