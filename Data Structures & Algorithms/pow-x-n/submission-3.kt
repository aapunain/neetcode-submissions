class Solution {
    fun myPow(x: Double, n: Int): Double {
        if(x == 0.0) {
            return 0.0
        }
        val pow = pow (x, abs(n))

        return if(n<0) 1 / pow else pow
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
