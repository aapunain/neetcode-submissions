/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null || subRoot == null) {
            return root == null && subRoot == null
        }

        return isSameTree(root, subRoot)
        || isSubtree(root?.left, subRoot)
        || isSubtree(root?.right, subRoot)
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?) :Boolean {
        if (p == null || q == null) {
            return p == null && q == null
        }

        if (p.`val` != q.`val`) {
            return false
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
 }
