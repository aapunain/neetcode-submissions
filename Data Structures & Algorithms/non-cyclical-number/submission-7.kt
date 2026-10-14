class Solution {
    fun isHappy(n: Int): Boolean {
        
        val visited = HashSet<Int>()
        var no = n

        while(!visited.contains(no)) {
            visited.add(no)

            var s = 0
            while(no > 0) {
                val d = no%10
                s += (no%10) * (no%10)
                no = no / 10
            }

            no = s

            if(no == 1) {
                return true
            }
        }

        return false

    }
}
