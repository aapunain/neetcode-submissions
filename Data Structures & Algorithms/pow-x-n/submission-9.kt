class Solution {
    fun myPow(x: Double, n: Int): Double {
        if(x == 0.0) {
            return 0.0
        }
        // val pow = pow (x, abs(n))
        val pow = powIterative (x, abs(n.toLong()))

        return if(n < 0) 1 / pow else pow
    }

    fun powIterative(xx: Double, n: Long): Double {
        if(n == 0L) {
            return 1.0
        }
        var res = 1.0
        var p = n
        var x = xx

        while(p > 1) {
            if(p % 2 == 1L){
                res = res * x 
            }

            x = x * x
            p = p / 2
        }

        return res * x
    }

    fun pow(x: Double, n: Int): Double {
        if(n == 0) {
            return 1.0
        }
        if(n == 1) {
            return x
        }
        
        val p = pow(x, n/2)

        return if(n % 2 ==0) {
            p * p
        } else {
            p * p * x
        }
    }
}
