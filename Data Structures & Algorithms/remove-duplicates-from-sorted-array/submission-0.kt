class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        
        if(nums.size == 1)
         return 1

        var k = 0
        var tracker = 1

        while(tracker < nums.size ) {

            if(nums[tracker] == nums[k]){
                tracker++
                continue
            }

            nums[++k] = nums[tracker++]

        }

        return k+1

    }
}
