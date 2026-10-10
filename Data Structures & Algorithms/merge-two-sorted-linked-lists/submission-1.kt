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
                l1 = l1!!.next
            } else {
                end.next = l2!!
                l2 = l2!!.next
            }
            end = end?.next!!
        }

        end?.next = l1 ?: l2

        return dummy.next

    }
}
