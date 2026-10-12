class LRUCache(capacity: Int) {
    private val capacity = capacity
    private val map = HashMap<Int, Node>()
    private val lru = DLL()
    private var currSize = 0

    fun get(key: Int): Int {
        val ex = map.getOrDefault(key, null)?.apply {
            lru.moveToLast(this)
        }
        return ex?.value ?: -1
    }

    fun put(key: Int, value: Int) {
        val existingNode = map.getOrDefault(key, null)
        if (existingNode != null) {
            existingNode.value = value
            lru.moveToLast(existingNode)
        } else {
            if(currSize == capacity) {
                lru.removeFirst()?.also{
                    map.remove(it.key)
                }
                lru.addNewNodeInLast(key, value).also {
                    map[key] = it
                }
            } else {
                lru.addNewNodeInLast(key, value).also {
                    map[key] = it
                }
                currSize++
            }
        }
    }

    class DLL {
        private val head = Node(0, 0)
        private var last = head

        fun addNewNodeInLast(key:Int, value:Int): Node {
            val n = Node(key, value)
            last.next = n
            n.prev = last
            last = n
            return n
        }

        fun moveToLast(node:Node) {
            if(node == last) {
                return
            } else {
                node.prev?.next = node.next
                node.next?.prev = node.prev

                last.next = node
                node.prev = last
                node.next = null
                last = node
            }
        }

        fun removeFirst(): Node? {
            if(head == last) {
                return null
            } else if (head.next == last) {
                val res = last
                head.next = null
                last.prev = null
                last = head
                return res
            } else {
                val fn = head.next
                head.next = fn?.next
                fn?.next?.prev = head
                return fn
            }
        }
    }

    class Node (
        val key: Int,
        var value: Int,
        var next: Node? = null,
        var prev: Node? = null
    )
}
