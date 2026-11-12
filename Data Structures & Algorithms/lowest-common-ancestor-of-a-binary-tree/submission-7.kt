/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    // check - solutions also
    var res: TreeNode? = null
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if(root == null || p == null || q == null) {
            return null
        }

        lca(root, p, q)
        return res
    }

    fun lca(root: TreeNode?, p: TreeNode, q: TreeNode): Boolean { // is any matched ?
        root ?: return false
        if(res != null) {
            return false
        }

        val left = lca(root.left, p, q)
        val right = lca(root.right, p, q)

        val rootMatched = root == p || root == q 

        if( (rootMatched && (left || right)) || 
            (left && right)
        ) {
            if(res == null) {
                res = root
            }
            return true
        } else {
            return rootMatched || left || right
        }

    }
}
