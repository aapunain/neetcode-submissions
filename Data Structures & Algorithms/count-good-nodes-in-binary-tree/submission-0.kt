/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        root ?: return 0
        return gnodes(root, root.`val`)
    }

    fun gnodes(root: TreeNode?, max: Int) :Int {
        root ?: return 0

        return (if(root.`val` >= max) 1 else 0) +
        gnodes(root.left , maxOf(max, root.`val`)) +
        gnodes(root.right , maxOf(max, root.`val`))
     }
}
