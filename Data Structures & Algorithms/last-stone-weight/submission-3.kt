class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        // can check last solution - bucket sort for specific case
        val maxHeap = PriorityQueue<Int>(reverseOrder()).apply{
            addAll(stones.toList())
        }
        while(maxHeap.size >= 2) {
            val d = maxHeap.poll() - maxHeap.poll()
            if(d != 0) {
                maxHeap.add(d)
            }
        }

        return if(maxHeap.size == 1) {
            maxHeap.poll()
        } else {
            0
        }

    }
}
