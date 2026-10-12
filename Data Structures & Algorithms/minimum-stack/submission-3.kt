class MinStack() {

    //val stack = ArrayDeque<Pair<Int, Int>>()
    val stack = ArrayDeque<Long>()
    var min :Long = 0L

    fun push(value: Int) {
        /*
        if (stack.isEmpty()) {
            stack.addLast(Pair(
                value, value
            ))
        } else {
            stack.addLast(Pair(
                value, minOf(stack.last.second, value)
            ))
        }
        */

        val valueL = value.toLong()

        if (stack.isEmpty()) {
            min = valueL
            stack.addLast(0L)
        } else {
            val entry = valueL - min 
            stack.addLast(entry)
            if (entry < 0) {
                min = valueL
            }
        }
    }

    fun pop() {
        // stack.removeLast()

        if (stack.isEmpty()) return

        val last = stack.removeLast()
        if(last < 0) {
            min = min - last
        }
    }

    fun top(): Int {
        // return stack.last()?.first ?: 0
        if(stack.isEmpty()) return 0
        val e = stack.last()
        return if(e >= 0 ) {
            min + e
        } else {
            min
        }.toInt()
    }

    fun getMin(): Int {
        // return stack.last()?.second ?: 0
        return min.toInt()
    }
}
