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
            val node = map[h] ?: Node(h!!.`val`).also{
                    map[h] = it
            }
            if(ans == null) {
                ans = node
                end = node
            } else {
                end?.next = node
                end = node
            }
            val random = h!!.random
            if(random == null) {
                node.random = null
            } else {
                val randomCopy = map[random] ?: Node(random.`val`).also{
                     map[random] = it
                }
               
                node.random = randomCopy
            }
        
            h = h?.next
        }

        return ans
    }
}
