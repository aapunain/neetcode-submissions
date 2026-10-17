class WordDictionary {

    val root = TNode()

    fun addWord(word: String) {
        var node = root
        for(c in word) {
            node = node.children[c - 'a'] ?: TNode().also {
                node.children[c - 'a'] = it
            }
        }

        node.isEnd = true
    }

    fun search(word: String): Boolean {
        return searchFromAnyNode(root, word, 0)
    }


    fun searchFromAnyNode(startNode: TNode, word: String, idx:Int): Boolean {
        if(idx == word.length) {
            return startNode.isEnd
        }
        var node = startNode

        for (i in idx..(word.length - 1)) {
            if (word[i] != '.') {
                node = node.children[word[i] - 'a'] ?: return false
            } else {
                for(child in node.children) {
                    if(child != null && searchFromAnyNode(child, word, i + 1)) {
                       return true
                   }
                }
                return false      
            }
        }
        return node.isEnd

    }


    class TNode{
        val children = arrayOfNulls<TNode>(26)
        var isEnd = false
    }
}
