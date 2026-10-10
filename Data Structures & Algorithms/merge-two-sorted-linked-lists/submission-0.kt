/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var end = dummy

        var l1 = list1
        var l2 = list2

        while(l1 != null && l2 != null) {
            val next = if(l1!!.`val` <= l2!!.`val`) {
                end.next = l1!!
                end = end?.next!!
                l1 = l1!!.next
            } else {
                end.next = l2!!
                end = end?.next!!
                l2 = l2!!.next
            }
        }

        if (l1!= null) {
            end?.next = l1
        } else {
            end?.next = l2
        }

        return dummy.next

    }
}
