/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        root ?: return emptyList()
        val res = mutableListOf<List<Int>>()
        val dq = ArrayDeque<TreeNode>()
        dq.addLast(root)
        var isLTR = true

        while(dq.isNotEmpty()) {
            val r = mutableListOf<Int>()

            var size = dq.size

            while (size-- > 0) {
                val node = dq.removeFirst()
                r.add(node.`val`)
                node.left?.let {dq.add(it)}
                node.right?.let {dq.add(it)}
            }

            res.add(if(isLTR) r else r.reversed())
            isLTR = !isLTR
        }

        return res
    }
}
