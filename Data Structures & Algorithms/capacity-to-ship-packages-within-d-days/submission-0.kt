class Solution {
    fun shipWithinDays(weights: IntArray, days: Int): Int {
        var l = weights.max()
        var r = weights.sum()

        while(l < r ) {
            val mid = l + ( r - l ) / 2
            if (canShipWithWeight(weights, days, mid)) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        return r
    }

    fun canShipWithWeight(weights: IntArray, days: Int, maxW :Int ) : Boolean {
        var i = 0
        for (d in 1..days) {
            var daysW = 0// total weight for the day
            while(daysW < maxW && i < weights.size) {
                if (daysW + weights[i] <= maxW) {
                    daysW = daysW + weights[i]
                    i++
                } else {
                    break
                }
             }
        }

        return i >= weights.size
        
    }
}
