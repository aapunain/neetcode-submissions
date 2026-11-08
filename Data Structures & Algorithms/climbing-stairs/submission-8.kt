class Solution {
    fun climbStairs(n: Int): Int {
        // val memory = IntArray(n+1).apply {
            // this[0] = 1
            // this[1] = 2
        // }
        // return climbInternal(n, memory)

        if(n <3) {
            return n
        }

        var twoStepBack = 1
        var oneStepBack = 2

        for(i in 3..n) {
            val temp = oneStepBack
            oneStepBack = oneStepBack + twoStepBack
            twoStepBack = temp
        }

        return oneStepBack

    }

    fun climbInternal(n:Int, memory: IntArray) :Int {
        if(n < 1) {
            return 0
        }

        if(memory[n-1] != 0) {
            return memory[n-1]
        }

        if(n == 1 || n == 2) {
            return n
        }

        return (climbInternal(n-1, memory) + climbInternal(n-2, memory)).also {
            memory[n-1] = it
        }
    }
}
