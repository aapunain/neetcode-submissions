class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
// brute force
/*
        val remainingFreq = IntArray(26)
        val lastScheduledAt = IntArray(26)

        tasks.forEach{
            remainingFreq[it - 'A']++
        }

        var remainingTasks = tasks.size
        var time = 0

        while (remainingTasks > 0) {
            time++
            val i = getMaxRemainingFreqIdxWhichCanBeScheduled(remainingFreq, lastScheduledAt, n , time)
            if (i == -1) {
                continue
            }

            remainingFreq[i]--
            lastScheduledAt[i] = time
            remainingTasks--

        }

        return time
*/

// with heap and queue

        val freq = MutableList<Int>(26) {0}

        tasks.forEach {
            freq[it - 'A']++
        }

        val maxHeap = PriorityQueue<Int>(reverseOrder())
        freq.forEach {
            if(it > 0) {
                maxHeap.add(it)
            }
        }
        val queue = ArrayDeque<Pair<Int, Int>>() // freq, time pair

        var time = 0

        while (maxHeap.isNotEmpty() || queue.isNotEmpty()) {
            if (maxHeap.isEmpty()) {
                val p = queue.removeFirst()
                time = p.second
                maxHeap.add(p.first)
            } else {
                time++
                if (queue.isNotEmpty() && queue.peekFirst().second <= time) {
                    maxHeap.add(queue.removeFirst().first)
                }
            }

            val fs = maxHeap.poll()
            if (fs - 1 > 0) {
                queue.addLast(Pair(fs - 1, time + n + 1))
            }

        }

        return time

    }

    fun getMaxRemainingFreqIdxWhichCanBeScheduled(remainingFreq: IntArray, lastScheduledAt: IntArray, n: Int, currentTime: Int): Int {
        var res = -1

        for (i in 0 until remainingFreq.size) {
            if (remainingFreq[i] == 0 || (lastScheduledAt[i] != 0 && lastScheduledAt[i] + n >= currentTime)) {
                continue
            } else {
                if (res == -1 || remainingFreq[i] > remainingFreq[res]) {
                    res = i
                }
            }
        }

        return res
    }
}
