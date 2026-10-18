class MedianFinder {

    // 0

    val maxHeap = PriorityQueue<Int>(reverseOrder())
    val minHeap = PriorityQueue<Int>()

    fun addNum(num: Int) {
            if(maxHeap.size == minHeap.size) {
                if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
                    maxHeap.add(num)
                } else {
                    minHeap.add(num)
                }
            } else if (maxHeap.size > minHeap.size) {
                if(num > maxHeap.peek()) {
                    minHeap.add(num)
                } else {
                    minHeap.add(maxHeap.poll())
                    maxHeap.add(num)
                }
            } else { // maxHeap.size < minHeap.size
                if(num <= minHeap.peek()) {
                    maxHeap.add(num)
                } else {
                    maxHeap.add(minHeap.poll())
                    minHeap.add(num)
                }
            }
    }

    fun findMedian(): Double {
        if (maxHeap.size == minHeap.size) {
            return (maxHeap.peek().toDouble() + minHeap.peek()) / 2
        } else if (maxHeap.size > minHeap.size) {
            return maxHeap.peek().toDouble()
        } else  {
            return minHeap.peek().toDouble()
        }
    }
}
