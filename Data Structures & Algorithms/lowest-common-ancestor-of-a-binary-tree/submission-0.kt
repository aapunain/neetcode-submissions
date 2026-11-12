/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if(root == null || p == null || q == null) {
            return null
        }

        try {
            lca(root, p, q)
            return null
        } catch (res: Ans) {
            return (res as Ans).node
        }
    }

    fun lca(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? { // has how many nodes 

        if(root == null) {
            return null
        }

        val left = lca(root.left, p, q)
        val right = lca(root.right, p, q)

        val rootMatched = root == p || root == q 

        if(rootMatched) {
            if(left!= null || right!= null) {
                throw Ans(root)
            } else {
                return root
            }
        } else {
            if(left != null && right != null) {
                throw Ans(root)
            } else {
                return left ?: right
            }
        }

    }

    class Ans(val node: TreeNode?) : RuntimeException()
}
