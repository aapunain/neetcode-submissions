class PrefixTree {

    val root = TNode()

    fun insert(word: String) {
        var node = root
        word.forEach {
            if(node.children[it - 'a'] == null) {
                node.children[it - 'a'] = TNode()
            }
            node = node.children[it - 'a']!!
        }
        node.isEnd = true
    }

    fun search(word: String): Boolean {
        var node = root
        word.forEach {
            if(node.children[it - 'a'] == null) {
                return false
            }
            node = node.children[it - 'a']!!
        }
        return node.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        prefix.forEach {
            if(node.children[it - 'a'] == null) {
                return false
            }
            node = node.children[it - 'a']!!
        }
        return node != null
    }

    class TNode {
        val children = Array<TNode?>(26) {null}
        var isEnd = false
        // word
        // prefixCount

    }
}
