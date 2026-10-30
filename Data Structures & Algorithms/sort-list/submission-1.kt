/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun sortList(head: ListNode?): ListNode? {
        head?.next ?: return head
        // return mergeSort(head)
        return iterativeMergeSort(head)

    }

    fun iterativeMergeSort(head: ListNode?) : ListNode? {

        var count = 0
        var node: ListNode? = head
        while (node != null) {
            count++
            node = node?.next
        }

        
        val dummyHead = ListNode(0).apply {
            next = head
        }
        var stepSize = 1
        var stepStart = dummyHead.next
        while (stepSize < count) {
            var remaining = dummyHead.next
            var end: ListNode? = dummyHead
            while (remaining != null) {
                var f = remaining
                var firstEnd = nextAfterStepInclusive(f, stepSize)
                var s = firstEnd?.next
                var secondEnd = nextAfterStepInclusive(s, stepSize)
                remaining = secondEnd?.next
                firstEnd?.next = null
                secondEnd?.next = null

                val merged = merge(f, s)
                end?.next = merged
                end = endOf(merged)
            }

            stepSize = stepSize * 2
        }

        return dummyHead.next
    }

    fun nextAfterStepInclusive(node:ListNode?, step :Int):ListNode? {
        var c = 1
        var n = node
        while(c < step && n!= null) {
            n = n.next
            c++
        }
        return n
    }


    fun endOf(node:ListNode?) :ListNode? {
        var n = node
        while(n?.next != null) {
            n = n?.next
        }
        return n
    }


    fun mergeSort(head:ListNode?) : ListNode? {
        head?.next ?: return head

        val mid = midOf(head)
        val second = mid?.next
        mid?.next = null
        val l1 = mergeSort(head)
        val l2 = mergeSort(second)
        return merge(l1, l2)
    }

    fun midOf(head:ListNode) : ListNode? {
        var slow: ListNode? = head
        var fast: ListNode? = head.next

        while(fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }
        return slow
    }

    fun merge(ll1:ListNode?, ll2:ListNode?) :ListNode? {
        var dummyHead = ListNode(0)
        var end: ListNode? = dummyHead 
        var l1 = ll1
        var l2 = ll2
        while (l1 != null && l2 != null) {
            if(l1.`val` <= l2.`val`) {
                end?.next = l1
                l1 = l1.next
            } else {
                end?.next = l2
                l2 = l2.next
            }
            end = end?.next
            end?.next = null
        }
        end?.next = l1 ?: l2
        return dummyHead.next
    }
}
