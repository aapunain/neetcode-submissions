/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var c = 0
    var res = -1

    fun kthSmallest(root: TreeNode?, k: Int): Int {
          inorder(root, k)
          return res
    }   

    fun inorder(root: TreeNode?, k: Int) {
       root ?: return 

       inorder(root.left, k)
        

       c++
       if(c== k) {
        res = root.`val`
        return
       }


        inorder(root.right, k)
      
    }
}
