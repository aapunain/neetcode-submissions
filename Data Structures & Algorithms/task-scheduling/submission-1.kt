class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {

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
