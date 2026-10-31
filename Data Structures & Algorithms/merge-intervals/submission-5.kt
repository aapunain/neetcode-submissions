class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
/*
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

        return res.toTypedArray()
*/

        var maxStart = intervals[0][0]
        intervals.forEach{
            if(it[0] > maxStart) {
                maxStart = it[0]
            }
        }

        val intv = IntArray(maxStart + 1) {
            -1
        }

        for (i in intervals.indices) {
            intv[intervals[i][0]] = maxOf(intervals[i][1], intv[intervals[i][0]])
        }

        

        val res = mutableListOf<IntArray>()

        var last: IntArray? = null
        for (i in intv.indices) {
            if(intv[i] == -1) {
                continue
            }

            val l = last
            if(l == null) {
                last = intArrayOf(i, intv[i])
            } else if(l[1] < i ) {
                res.add(last)
                last = intArrayOf(i, intv[i])
            } else {
                last = intArrayOf(last[0], maxOf(last[1], intv[i]))
            }
        }

        if (last != null) {
            res.add(last)
        }

        return res.toTypedArray()

    }
}
