/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxPathSum(root: TreeNode?): Int {
        root ?: return -1
        return post(root)!!.first
    }

    fun post(root: TreeNode?) : Pair<Int, Int>? { // ans , max contri if we take this node
        root ?: return null

        val left = post(root.left)
        val right = post(root.right)

val leftGain = left?.second?: 0
val rightGain = right?.second?: 0

        var ans = maxOf(root.`val`,
        root.`val` + leftGain, 
        root.`val` + rightGain,
        root.`val` + leftGain + rightGain)

        if(left != null) {
           ans = maxOf(ans, left.first )
        }

        if(right != null) {
            ans = maxOf(ans, right.first )
        }



        return Pair(
            ans,
            maxOf (root.`val`, root.`val` + leftGain, root.`val` + rightGain)

        )
    }
}
