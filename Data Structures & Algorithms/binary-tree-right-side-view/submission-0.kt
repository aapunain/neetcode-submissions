/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        root ?: return emptyList()
        val res = mutableListOf<Int>()
        val dq = ArrayDeque<TreeNode>()
        dq.addLast(root)

        while(dq.isNotEmpty()) {
            val ls = dq.size
            for(i in 1..ls) {
                val node = dq.removeFirst()
                node.left?.let { dq.addLast(it) }
                node.right?.let { dq.addLast(it) }
                if(i == ls) {
                    res.add(node.`val`)
                }
            }
        }

        return res
    }
}
