/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val inorder = mutableListOf<Int>()
        inorder(root, inorder)
        if(inorder.size < k) {
            return -1
        }
        return inorder[k-1]
    }

    fun inorder(root: TreeNode?, inorder: MutableList<Int>) {
        root ?: return
        inorder(root.left, inorder)
        inorder.add(root.`val`)
        inorder(root.right, inorder)
    }
}
