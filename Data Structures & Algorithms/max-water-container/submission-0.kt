class Solution {
    fun maxArea(heights: IntArray): Int {
        var max = 0
        var s = 0
        var e = heights.size - 1
        while(s < e) {
            max = maxOf(max, (e-s) * minOf(heights[s], heights[e]))
            if (heights[s]< heights[e]) {
                s++
            } else {
                e--
            }
        }
        return max
    }
}
