/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        root ?: return null
        

        val left = invertTree(root?.left)
        val right = invertTree(root?.right)
        root?.left = right
        root?.right = left
        return root
    }
}
