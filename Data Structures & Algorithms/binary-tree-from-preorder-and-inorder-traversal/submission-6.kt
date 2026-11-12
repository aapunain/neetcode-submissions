/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    // pre = root , l , r
    // in  = l , root , r
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if(preorder.isEmpty() || inorder.isEmpty()) {
            return null
        }

        val root = TreeNode(preorder[0])
        val rootIndexInorder = inorder.indexOf(preorder[0])


        root.left = buildTree(
            preorder.sliceArray(1..rootIndexInorder),
            inorder.sliceArray(0 until rootIndexInorder)
        )

        root.right = buildTree(
            preorder.sliceArray(rootIndexInorder + 1..preorder.size - 1),
            inorder.sliceArray(rootIndexInorder + 1.. inorder.size - 1)
        )

        return root
        

    }
}
