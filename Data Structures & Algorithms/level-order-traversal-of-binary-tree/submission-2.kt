/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        root ?: return emptyList()

        val res = mutableListOf<List<Int>>()

        val dq = ArrayDeque<TreeNode>()

        dq.addLast(root)

        while(dq.isNotEmpty()) {
            
            val level = mutableListOf<Int>()

            for(i in 1..dq.size) {
                val node = dq.removeFirst()
                level.add(node.`val`)
                node.left?.also {
                    dq.addLast(it)
                }
                node.right?.also {
                    dq.addLast(it)
                }
            }
            
            res.add(level)
        }


        return res

    }
}
