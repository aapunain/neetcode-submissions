class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = ArrayDeque<Int>() // monotonic stack - decreasing
        val res = IntArray(temperatures.size)

        for (i in temperatures.indices) {
            while(!stack.isEmpty() && temperatures[stack.last()] < temperatures[i]) {
                val idx = stack.removeLast()!!
                res[idx] = i - idx
            }
            stack.addLast(i)
        }
        while(!stack.isEmpty()) {
            val idx = stack.removeLast()!!
            res[idx] = 0
        }

        return res

    }
}
