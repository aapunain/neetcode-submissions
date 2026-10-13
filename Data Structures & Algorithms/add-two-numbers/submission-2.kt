/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        
        var cf = 0
        var ans: ListNode? = null
        var end:ListNode? = null

        var ll1 = l1
        var ll2 = l2

        while (ll1 != null || ll2 != null || cf!= 0) {
            val n = (ll1?.`val` ?: 0) + (ll2?.`val` ?: 0) + cf
            val node = ListNode(n % 10)
            cf = n /10
            if (ans == null) {
                ans = node
                end = node
            } else {
                end?.next = node
                end = node
            }
            ll1 = ll1?.next
            ll2 = ll2?.next
        }

        return ans

    }
}
