class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {

        if(nums.size ==2) {
            return intArrayOf(nums[1], nums[0])
        }

        val pre = IntArray(nums.size)
        val post = IntArray(nums.size)

        pre[0] = 1
        pre[1] = nums[0]
        for(i in 2 until nums.size) {
            pre[i] = pre[i-1] * nums[i-1]
        }

        post[nums.size - 1] = 1
        post[nums.size - 2] = nums[nums.size - 1]
        for(i in nums.size - 3 downTo 0) {
            post[i] = post[i+1] * nums[i+1]
        }

        return IntArray(nums.size) {
            pre[it] * post[it]
        }
    }
}
