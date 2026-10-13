class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {

        val pairs = position.zip(speed).sortedByDescending {
            it.first
        }

        val stack = ArrayDeque<Double>()

        for((p, s) in pairs) {
            val t = (target - p).toDouble() / s
            if(stack.isEmpty()) {
                stack.addLast(t)
            } else {
                if(t > stack.last()) {
                    stack.addLast(t)
                }
            }
        }
       
       return stack.size

    }

   
}
