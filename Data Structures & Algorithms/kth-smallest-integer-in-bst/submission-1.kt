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
        inorder(root, inorder, k)
        if(inorder.size < k) {
            return -1
        }
        return inorder[k-1]
    }

    fun inorder(root: TreeNode?, inorder: MutableList<Int>, k: Int) {
        root ?: return
        inorder(root.left, inorder, k)
        inorder.add(root.`val`)
        if(inorder.size == k) {
            return
        }
        inorder(root.right, inorder, k)
    }
}
