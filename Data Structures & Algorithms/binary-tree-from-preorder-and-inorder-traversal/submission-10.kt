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
        
        // return bf(preorder, inorder)

        val indexMap = mutableMapOf<Int, Int>()
        for (i in inorder.indices) {
            indexMap[inorder[i]] = i
        }
        return buildTreeInternal(preorder, indexMap, 0, preorder.lastIndex, 0, inorder.lastIndex)
    }


    fun buildTreeInternal(preorder: IntArray, indexMap: Map<Int, Int>,
    ps:Int, pe:Int, ios:Int, ioe:Int ): TreeNode? {

        if(pe - ps < 0 || ioe - ios < 0) {
            return null
        }

        if(pe - ps == 0 || ioe - ios == 0) {
            return TreeNode(preorder[ps])
        }
        

        val root = TreeNode(preorder[ps])
        val rootIndexInorder = indexMap[preorder[ps]]!!


        val leftSize = rootIndexInorder - ios
        root.left = buildTreeInternal(
            preorder, indexMap,
            ps + 1, ps + leftSize,
            ios, rootIndexInorder-1
        )

        root.right = buildTreeInternal(
            preorder, indexMap,
            ps + leftSize + 1, pe, 
            rootIndexInorder + 1, ioe
        )

        return root


    }

    fun bf(preorder: IntArray, inorder: IntArray): TreeNode? {
        if(preorder.isEmpty() || inorder.isEmpty()) {
            return null
        }

        val root = TreeNode(preorder[0])
        val rootIndexInorder = inorder.indexOf(preorder[0])


        root.left = bf(
            preorder.sliceArray(1..rootIndexInorder),
            inorder.sliceArray(0 until rootIndexInorder)
        )

        root.right = bf(
            preorder.sliceArray(rootIndexInorder + 1..preorder.size - 1),
            inorder.sliceArray(rootIndexInorder + 1.. inorder.size - 1)
        )

        return root
    }
}
