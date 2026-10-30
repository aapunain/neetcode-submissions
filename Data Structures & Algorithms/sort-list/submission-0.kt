/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun sortList(head: ListNode?): ListNode? {
        head?.next ?: return head
        return mergeSort(head)


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
