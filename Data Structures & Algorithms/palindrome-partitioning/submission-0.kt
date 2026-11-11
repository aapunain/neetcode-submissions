class Solution {
    
    val res = mutableListOf<List<String>>()
    
    val partitions = mutableListOf<Pair<Int, Int>>()

    fun partition(s: String): List<List<String>> {
        val isPalindrome = Array<IntArray>(s.length)  {
            IntArray(s.length) // 0 - not calculated, 1 - is , 2 - is not
        }

        partition(s, 0, s.length - 1, isPalindrome)

        return res
    }

    fun partition(str:String, s: Int, e:Int, isPalindrome: Array<IntArray>) {
        if(s == str.length) {
            partitions.map {
                str.substring(it.first, it.second + 1)
            }.also {
                res.add(it)
            }
            return
        }

        for(i in s..e) {
            if(isPalindrome(str, s, i, isPalindrome)) {
                partitions.add(s to i)
                partition(str, i+1, e, isPalindrome)
                partitions.removeLast()
            }
        }
    }

    fun isPalindrome(str:String, s:Int, e:Int, isPalindrome: Array<IntArray>):Boolean {
        if(isPalindrome[s][e] == 1) {
            return true
        } else if(isPalindrome[s][e] == 2) {
            return false
        } else {
            var res = true
            var i = s
            var j = e
            while(i < j) {
                if(str[i] != str[j]) {
                    res = false
                    break
                }
                i++
                j--
            }

            isPalindrome[s][e] = if(res) 1 else 2
            return res
        }
    }
}
