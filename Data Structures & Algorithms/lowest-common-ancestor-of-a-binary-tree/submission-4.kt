/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    // check - solutions also
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

    fun lca(root: TreeNode?, p: TreeNode, q: TreeNode): Boolean { // is any matched ?
        root ?: return false

        val left = lca(root.left, p, q)
        val right = lca(root.right, p, q)

        val rootMatched = root == p || root == q 

        if( (rootMatched && (left || right)) || 
            (left && right)
        ) {
            throw Ans(root)
        } else {
            return rootMatched || left || right
        }

    }

    class Ans(val node: TreeNode?) : RuntimeException()
}
