class Solution {
    fun largestNumber(nums: IntArray): String {

        // this dont work - complex and confusing
        // cSort(nums, 0, nums.size - 1, 1000000000)

  
        return nums.map{
            it.toString()
        }.sortedWith {
            a, b -> (b + a).compareTo(a + b)
        }.joinToString("").let{
            if(it[0] == '0') "0" else it
        }

    }

// this dont work - complex and confusing
    fun cSort(input: IntArray, s:Int, e:Int, place:Int) {
        if(place < 1 || s == e) {
            return
        }
        
        val count = IntArray(10)
        val nextCall = IntArray(10)

        for(i in s..e) {
            val digit = (input[i] / place) % 10
            count[digit]++
            nextCall[digit]++
        }

        for(i in 8 downTo 0) {
            count[i] = count[i] + count[i + 1]
            nextCall[i] = nextCall[i] + nextCall[i + 1]
        }

        val out = IntArray(e - s + 1)

        for(i in s..e) {
            val n = (input[i] / place) % 10
            out[count[n] - 1] = input[i]
            count[n]--
        }

        for(i in out.indices) {
            input[s+i] = out[i]
        }

        for(i in nextCall.indices) {
            val c = if (i == 9) nextCall[i] else nextCall[i] - nextCall[i+1]
            if(c != 0) {
                val start = if (i == 9) s else nextCall[i+1]
                val end = nextCall[i] - 1
                cSort(input, start, end, place / 10)
            }
        }


    }
}
