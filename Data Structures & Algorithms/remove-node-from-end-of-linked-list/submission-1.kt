/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {       

        // 1 2 3 4 5 6 7 8 9

        var f = head
        var s = head

        for(i in 1..n) {
            s = s?.next
        }

        if(s == null) { // to remove first node
            return head?.next
        }

        while(s?.next != null) {
            f = f?.next
            s = s?.next
        }

        f?.next = f?.next?.next

        return head

    }
}
