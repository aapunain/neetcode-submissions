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
        var levelCount = 1

        while(dq.isNotEmpty()) {
            
            val level = mutableListOf<Int>()
            var lc = 0

            for(i in 1..levelCount) {
                val node = dq.removeFirst()
                level.add(node.`val`)
                node.left?.also {
                    dq.addLast(it)
                    lc++
                }
                node.right?.also {
                    dq.addLast(it)
                    lc++
                }
            }
            
            res.add(level)
            levelCount = lc
        }


        return res

    }
}
