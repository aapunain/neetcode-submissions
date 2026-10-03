class Solution {

    fun encode(strs: List<String>): String {

        val out = StringBuilder()

        strs.forEach{
            out.append(it.length.toString())
                .append('#')
                .append(it)
        }

        return out.toString()

    }

    fun decode(str: String): List<String> {

        val res = mutableListOf<String>()

        var pointer = 0
        while(pointer < str.length) {

            var nextLengthString = StringBuilder()
            while(str[pointer] != '#') {
                nextLengthString.append(str[pointer])
                pointer++
            }

            val nextLength = nextLengthString.toString().toInt()
            if (nextLength == 0) {
                res.add("")
            } else {
                res.add(str.substring(pointer + 1, pointer + 1 + nextLength))
            }
    
            pointer = pointer + nextLength + 1
        }
        return res
    }
}
