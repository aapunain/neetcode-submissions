class StockSpanner() {

    private val stack = ArrayDeque<Pair<Int, Int>>() // price, day
    private var day = 0

    fun next(price: Int): Int {
        if(stack.isEmpty()) {

            stack.addLast(price to 1)
            day = 1
            return day
        } else {
            while (!stack.isEmpty() && stack.last().first <= price) {
                stack.removeLast()
            }
            if (stack.isEmpty()) {
                day++
                stack.addLast(price to day)
                return day
            } else {
                day++
                val res = day - stack.last().second
                stack.addLast(price to day)
                return res
            }
        }

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * val obj = StockSpanner()
 * val param_1 = obj.next(price)
 */
