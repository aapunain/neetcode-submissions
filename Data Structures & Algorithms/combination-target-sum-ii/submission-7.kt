class Solution {
    val res = mutableListOf<List<Int>>()
    val currentSet = mutableListOf<Int>()
    var currentTotal = 0
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        bt(candidates, target, 0)
        return res
    }

    fun bt(candidates: IntArray, target: Int, idx:Int) {


        if (currentTotal == target) {
            res.add(currentSet.toList())
            return
        }

        if(currentTotal > target || idx == candidates.size) {
            return
        }

        var count = 0
        for(i in idx until candidates.size) {
            if(candidates[idx] == candidates[i]) {
                count++
            } else {
                break
            }
        }

        for(c in 0..count) {
            if (currentTotal + candidates[idx] * c  > target) {
                break;
            }
            var addedCount = 0
            for (i in 1..c) {
                currentSet.add(candidates[idx])
                currentTotal += candidates[idx]
                addedCount++
            }

            bt(candidates, target, idx + count)

            for (i in 1..addedCount) {
                currentSet.removeLast()
                currentTotal -= candidates[idx]
            }
        }
    }
}
