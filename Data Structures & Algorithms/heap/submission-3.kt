class MinHeap {

    val heap = mutableListOf<Int>()

    fun push(value: Int) {
        heap.add(value)
        correctUp(heap.size - 1)
    }

    fun pop(): Int {
        if(heap.isEmpty()) {
            return -1
        }

        val res = heap[0]
        heap[0] = heap[heap.size -1]
        heap.removeLast()
        correctDown(0)
        return res
    }

    fun top(): Int {
        if(heap.isEmpty()) {
            return -1
        } else {
            return heap[0]
        }
    }

    fun heapify(nums: MutableList<Int>) {
        heap.clear()
        heap.addAll(nums)
        for ( i in nums.size / 2 downTo 0 ) {
            correctDown(i)
        }
    }

    fun correctDown(index :Int) {
        if(index >= heap.size) {
            return
        }

        var idx = index
        while(idx < heap.size) {
            val l = 2 * idx +1
            val r = l + 1

            var min = idx 

            if(l < heap.size && heap[l] < heap[min]) {
                min = l
            }
            if(r < heap.size && heap[r] < heap[min]) {
                min = r
            }
            if(idx == min) {
                break
            } else {
                heap[idx] = heap[min].also{
                    heap[min] = heap[idx]
                }
                idx = min
            }
        }
    }

    fun correctUp(index :Int) {
        var i = index
        while (i > 0) {
            val parent = (i - 1) / 2
            if(heap[parent] > heap[i]) {
                heap[i] = heap[parent].also {
                    heap[parent] = heap[i]
                }
                i = parent
            } else {
                break
            }
        }
    }
}
