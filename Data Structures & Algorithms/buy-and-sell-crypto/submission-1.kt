class Solution {
    fun maxProfit(prices: IntArray): Int {
        if(prices.size <= 1){
            return 0
        }

        var profit = 0
        var minPriceIndex = 0

        for (i in  0 .. (prices.size - 1)  ) {
            if(prices[minPriceIndex] >= prices[i]) {
                minPriceIndex = i
                continue
            } else {
                profit = maxOf(profit, prices[i] - prices[minPriceIndex])
            }
        }
        return profit
    }
}
