/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun middleNode(head: ListNode?): ListNode? {

        var mid = head
        var end = head



        while (end?.next != null) {
            mid = mid?.next
            end = end?.next?.next
        }

        return mid

    }
}
