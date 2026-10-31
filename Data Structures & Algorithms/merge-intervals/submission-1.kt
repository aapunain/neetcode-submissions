class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy {
            it[0]
        }

        val res = mutableListOf<IntArray>()

        var last = intervals[0]
        for (i in 1..intervals.size - 1) {
            val arr = intervals[i]
            if(arr[0] > last[1]) {
                res.add(last)
                last = arr
            } else {
                last = intArrayOf(last[0], maxOf(last[1], arr[1]))
            }
        }
        res.add(last)



        return Array<IntArray>(res.size) {
            res[it]
        }
    }
}
