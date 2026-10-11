/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {

        head?.next ?: return

        var slow = head
        var fast = head
        var beforeMid: ListNode? = null

        while(fast?.next != null) {
            beforeMid = slow
            slow = slow?.next
            fast = fast?.next?.next
        }
        beforeMid?.next = null


        // now slow is at mid (2nd half)
        // reverse 2nd half

        var first: ListNode? = null
        var second = slow
        var next: ListNode? = null
        while(second != null) {
            next = second?.next
            second?.next = first
            first = second
            second = next
        }
        slow?.next = null

        // now first is at end of reversed second half

        // now merge these 
        var f = head
        var s = first

        while(f?.next != null) {
            val tf = f?.next
            val ts = s?.next
            f?.next = s
            s?.next = tf
            s = ts
            f = tf
        }
        f?.next = s
    }
}
