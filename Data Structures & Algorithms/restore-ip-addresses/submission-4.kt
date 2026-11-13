class Solution {
    val res = mutableListOf<String>()
    val dotPos = mutableListOf<Int>()
    fun restoreIpAddresses(s: String): List<String> {
        if(s.length > 12) {
            return res
        }
        bt(s)
        return res
    }

    fun bt(s: String) { // pos after index
        if(dotPos.size == 3) {
            if(s.substring(dotPos.last(), s.length).isValid()) {
                res.add(
                    StringBuilder()
                        .append(s.substring(0, dotPos[0]))
                        .append(".")
                        .append(s.substring(dotPos[0], dotPos[1]))
                        .append(".")
                        .append(s.substring(dotPos[1], dotPos[2]))
                        .append(".")
                        .append(s.substring(dotPos[2], s.length))
                        .toString()
                )
            }
            return
        }
        val lastPos = if(dotPos.isEmpty()) 0 else dotPos.last()
        
        for (i in lastPos+1..lastPos+3){
            if (i > s.lastIndex) {
                break
            }
            if (s.substring(lastPos, i).isValid()) {
                dotPos.add(i)
                bt(s)
                dotPos.removeLast()
            }
        }
        
    }

    fun String.isValid() :Boolean {
        if(this.isEmpty() || this.length > 3) {
            return false
        } else if (this[0] == '0' && this.length > 1) {
            return false
        } else {
            val n = this.toInt()
            return n >= 0 && n <= 255
        }
    }
}
