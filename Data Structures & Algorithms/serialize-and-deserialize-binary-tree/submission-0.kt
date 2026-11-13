/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {
    private val marker = TreeNode(0)
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        root ?: return ""
        val res = StringBuilder()
        val dq = ArrayDeque<TreeNode>()
        dq.addLast(root)
        while(dq.isNotEmpty()) {
            var size = dq.size
        
            while(size-- > 0) {
                val node = dq.removeFirst()
               
                if(node != marker) {
                    node.left.let { dq.addLast(it ?: marker)}
                    node.right.let { dq.addLast(it ?: marker)}
                }
                res.apnd(node)
            }

        }

        return res.toString()
    }

    fun StringBuilder.apnd(node : TreeNode) {
        if(!this.isEmpty()) {
            this.append(",")
        }
        this.append( if (node != marker) node.`val`.toString() else "N" )
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if(data.isEmpty()) {
            return null
        }
        val nodes = data.split(",")

        var index = 0

        val dq = ArrayDeque<TreeNode>()
        val res = nodes[index++].toNode()!!
        dq.addLast(res)

        while (dq.isNotEmpty()) {
            var lc = dq.size 

            while(lc > 0) {
                val node = dq.removeFirst()
                node.left = nodes[index++].toNode().also{
                    if(it!= null) {
                        dq.addLast(it)
                    }
                }
                node.right = nodes[index++].toNode().also{
                    if(it!= null) {
                        dq.addLast(it)
                    }
                }
                lc--
            }

        }

        return res

    }

    fun String.toNode() = if(this == "N") null else TreeNode(this.toInt())
}
