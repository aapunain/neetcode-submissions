/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
            root ?: return null
            p ?: return null
            q ?: return null

            return if(root.`val` < minOf(p.`val`, q.`val`)) {
                lowestCommonAncestor(root.right, p , q)
            } else if (root.`val` > maxOf(p.`val`, q.`val`)) {
                lowestCommonAncestor(root.left, p , q)
            } else {
                root
            }
    }
}
