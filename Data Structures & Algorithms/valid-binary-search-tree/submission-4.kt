/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun valid(node: TreeNode?, left: Long, right: Long): Boolean {
        if (node == null) {
            return true
        }

        val value = node.`val`.toLong()
        if (value <= left || value >= right) {
            return false
        }

        return valid(node.left, left, value) &&
               valid(node.right, value, right)
    }
}