class KthLargest(kth: Int, nums: IntArray) {

    val minHeap = PriorityQueue<Int>()
    var max = Int.MIN_VALUE
    var size = 0
    val k = kth

    init {
        for (n in nums) {
            add(n)
        }
    }

    fun add(value: Int): Int {
        if(size < k ) {
            minHeap.add(value)
            if(value > max) {
                max = value
            }
            size++
        } else {
            if(value <= minHeap.peek()) {
                // do noting
            } else {
                minHeap.poll()
                minHeap.add(value)
            }
        }
        return minHeap.peek()
    }
}
