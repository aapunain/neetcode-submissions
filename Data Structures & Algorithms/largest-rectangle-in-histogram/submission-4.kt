class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        // return bf_largestRectangleArea(heights)
        return mn_largestRectangleArea(heights)
    }

    fun mn_largestRectangleArea(heights: IntArray) :Int {
        // monitonic stack 
        val adq = ArrayDeque<Int>() // hold index - monotonic stack - with incresing
        val minRight = IntArray(heights.size)
        val minLeft = IntArray(heights.size)

        for (i in heights.indices) {
            if(adq.isEmpty()){
                adq.addLast(i)
            } else if (heights[adq.peekLast()] <= heights[i]) {
                adq.addLast(i)
            } else {
                while(!adq.isEmpty() && heights[adq.peekLast()] > heights[i]) {
                    minRight[adq.removeLast()] = i
                }
                adq.addLast(i)
            }
        }
        while(adq.isNotEmpty()) {
            minRight[adq.removeLast()] = heights.size
        }


        for (i in (heights.size - 1) downTo 0) {
            if(adq.isEmpty()){
                adq.addLast(i)
            } else if (heights[adq.peekLast()] <= heights[i]) {
                adq.addLast(i)
            } else {
                while(!adq.isEmpty() && heights[adq.peekLast()] > heights[i]) {
                    minLeft[adq.removeLast()] = i
                }
                adq.addLast(i)
            }
        }
        while(adq.isNotEmpty()) {
            minLeft[adq.removeLast()] = -1
        }

        var res = 0

        for (i in heights.indices) {
            val l = minLeft[i] + 1
            val r = minRight[i] - 1

            res = maxOf(res, (r-l+1)*heights[i])
        }
        return res
        
    }

// bf is ok but time limit - also check bf of solution - that better to go for perfect solution
    fun bf_largestRectangleArea(heights: IntArray): Int {
        var res = 0
        for (i in 0..heights.size - 1) {
            var min = heights[i]
            for (j in i..heights.size -1) {
                if (heights[j] <= min) {
                    min = heights[j]
                }
                res = maxOf(res, (j-i+1)*min)
            }
        }
        return res
    }
}
