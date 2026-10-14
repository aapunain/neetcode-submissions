class Solution {
    fun isHappy(n: Int): Boolean {
        
        val visited = HashSet<Int>()
        var no = n

        while(!visited.contains(no)) {
            visited.add(no)

            no = sumOfSquare(no)

            if(no == 1) {
                return true
            }
        }

        return false

    }

    fun sumOfSquare(n: Int): Int {
        var no = n
        var s = 0
        while(no > 0) {
            s += (no%10) * (no%10)
            no = no / 10
        }
        return s
    }
}
