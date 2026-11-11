/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        return checkBalance(root).second
    }

    fun checkBalance(root: TreeNode?) : Pair<Int, Boolean> { // height of node, is balanced
        root ?: return Pair(0, true)

        val left = checkBalance(root.left)

        if(!left.second) {
            return Pair(-1, false)
        }

        val right = checkBalance(root.right)

        if(!right.second) {
            return Pair(-1, false)
        }

        return Pair(
            maxOf(left.first +1, right.first +1),
            abs(left.first - right.first) < 2
        )
    }
}
