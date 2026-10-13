/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        val map = HashMap<Node, Node>()

        var ans: Node? = null
        var end: Node? = null

        var h = head

        while(h != null) {
            val node = Node(h!!.`val`)
            if(ans == null) {
                ans = node
                end = node
            } else {
                end?.next = node
                end = node
            }
            map[h] = node
            h = h?.next
        }

        h = head
        end = ans
        while(h != null) {
            if(h?.random == null) {
                end?.random = null
            } else {
                end?.random = map[h?.random]
            }
            h = h?.next
            end = end?.next
        }

        return ans
    }
}
