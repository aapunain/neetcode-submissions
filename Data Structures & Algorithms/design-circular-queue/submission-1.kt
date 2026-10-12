class MyCircularQueue(k: Int) { 
    private val cap = k
    private val q = IntArray(k)
    private var size = 0
    private var head = 0


    fun enQueue(value: Int): Boolean {
        if(isFull()) return false

        q[(head + size) % cap] = value
        size++
        return true
    }

    fun deQueue(): Boolean {
        if(isEmpty()) return false

        head = (head + 1) % cap
        size--
        return true
    }

    fun Front(): Int {
        if(isEmpty()) return -1
        return q[head]
    }

    fun Rear(): Int {
        if(isEmpty()) return -1
        return q[(head + size -1 )% cap]
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun isFull(): Boolean {
        return size == cap
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */
