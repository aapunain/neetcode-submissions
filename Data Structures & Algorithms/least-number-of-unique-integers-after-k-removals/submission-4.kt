class Solution {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        val freqMap = HashMap<Int, Int>()
        arr.forEach {
            freqMap[it] = freqMap.getOrDefault(it, 0) + 1
        }

/*        val minHeap = PriorityQueue(freqMap.values)

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
        */

        val freqArr = IntArray(arr.size + 1)

        for (f in freqMap.values) {
            freqArr[f]++
        }

        var res = freqMap.size
        var remaining = k

        for (i in 1 until freqArr.size) {
            if (i * freqArr[i] < remaining) {
                remaining = remaining - i * freqArr[i]
                res = res - freqArr[i]
            } else {
                res = res - remaining / i
                break
            }
        }

        return res

    }
}
