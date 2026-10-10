/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        head?.next ?: return head

        //  return revByRecursion(head).apply {
          //    second.next = null
        //  }.first


        //      1 2 3 4 5 
        //              f n

        var first: ListNode ?= null
        var second = head
        var next: ListNode? = null

        while ( second != null ) {
            next = second?.next
            second?.next = first
            first = second
            second = next
        }

        return first

    }

    fun revByRecursion(node : ListNode) : Pair<ListNode, ListNode> {
        node.next ?: return node to node

  
        val res = revByRecursion(node.next!!)
        res.second.next = node
        return res.first to node

    }
 }
