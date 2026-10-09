class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {

        var max = 0
        for (p in piles) {
            max = maxOf(max, p)
        }

        var l = 1
        var r = max

        while (l < r) {
            val mid = l + (r-l) /2

            if(canEatWithRate(piles, h , mid)) {
                r = mid
            } else {
                l = mid + 1
            }
        }

        return r

    }

    fun canEatWithRate(piles: IntArray, h: Int, r: Int) : Boolean {
        var rh = h
        for(i in piles.indices) {
            val hc = ((piles[i] / r) + if (piles[i] % r > 0 ) 1 else 0)
            rh = rh - hc
            if(rh < 0 ){
                break
            }
        }
        return rh >= 0
    }
}
