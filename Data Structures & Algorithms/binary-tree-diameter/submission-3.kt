/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        return dia(root).first
    }

    fun dia(root : TreeNode?) :Pair<Int, Int> { // dia of node, max edges from this node on either side
        root ?: return Pair(0, -1)

        val left = dia(root.left)
        val right = dia(root.right)

        return Pair(
            maxOf(left.second + 1 + right.second + 1, left.first, right.first),
            maxOf(left.second + 1 , right.second + 1)
        )
    }
}
