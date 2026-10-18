class Solution {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        val freqMap = HashMap<Int, Int>()
        arr.forEach {
            freqMap[it] = freqMap.getOrDefault(it, 0) + 1
        }
        val minHeap = PriorityQueue(freqMap.values)

        var res = freqMap.size
        var kk = k

        while (kk > 0 && minHeap.isNotEmpty()) {
            val mf = minHeap.poll()
            if(mf <= kk) {
                kk = kk - mf
                res--
            }
        }

        return res
    }
}
