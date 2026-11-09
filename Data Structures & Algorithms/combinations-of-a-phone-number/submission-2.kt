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

        for (digit in digits) {
            val keys = mapper[digit]!!
            val newr = mutableListOf<String>()
            for (key in keys) {
                for (r in res) {
                    newr.add(r + key)
                }
            }
            res = newr
        }

        return res
    }
}
