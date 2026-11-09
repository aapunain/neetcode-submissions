class Solution {
    val mapper = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }

        var res = mutableListOf<String>("")

        for (idx in 0 until digits.length) {
            val keys = mapper[digits[idx]]!!
            val newr = mutableListOf<String>()
            for (k in 0 until keys.length) {
                for (r in res) {
                    newr.add(r + keys[k])
                }
            }
            res = newr
        }

        return res
    }
}
