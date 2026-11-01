class Solution {
    class Freq (var first:Char, var second:Int)

    fun frequencySort(s: String): String {
        val freq = Array<Freq?>(128) {
            null
        }
        s.forEach { char ->
            freq[char.code] = (freq[char.code] ?: Freq(char, 0)).apply {
                second = second + 1
            }
        }

        freq.sortBy {
            -(it?.second ?: 0)
        }

        val res = StringBuilder()
        freq.forEach {
            var c = it?.second ?: 0
            if (c > 0) {
                while(c > 0) {
                    res.append(it!!.first)
                    c--
                }
            }
        }
        return res.toString()
    }
}