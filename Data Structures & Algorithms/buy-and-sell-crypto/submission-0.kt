class Solution {
    fun maxProfit(prices: IntArray): Int {
        if(prices.size <= 1){
            return 0
        }

        var profit = 0
        var maxPriceIndex = prices.size - 1

        for (i in  (prices.size - 2) downTo 0 ) {
            if(prices[maxPriceIndex] <= prices[i]) {
                maxPriceIndex = i
                continue
            } else {
                profit = maxOf(profit, prices[maxPriceIndex] - prices[i])
            }
        }
        return profit
    }
}
