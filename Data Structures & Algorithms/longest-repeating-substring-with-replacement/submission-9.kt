class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        if (s.length <=0) {
            return s.length
        }

        var max = 0

/* wrong
        val freqInWindow = IntArray(26)
        var start = 0
        var end = 0

        var diffsInWindow = 0

        do {
            if(s[end] == s[start]) {
                end++
                freqInWindow[s[start] - 'A'] = freqInWindow[s[start] - 'A'] + 1
                max = maxOf(max, end-start)
            } else {
                if(diffsInWindow < k) {
                    diffsInWindow++
                    freqInWindow[s[end] - 'A'] = freqInWindow[s[end] - 'A'] + 1
                    end++
                    max = maxOf(max, end - start)
                } else {
                    freqInWindow[s[start] - 'A'] = freqInWindow[s[start] - 'A'] - 1
                    start++

                
                    if(s[start] != s[end]) {
                        var newDiffs = 0
                        for(i in 0..25) {
                            if(s[start] - 'A' != i) {
                                newDiffs+=freqInWindow[i]
                            }
                        }
                        diffsInWindow = newDiffs
                    }

                    max = maxOf(max, end - start)
                }
            }

            
        } while(end < s.length)
*/


/* brute force
        for (i in 0 until s.length) {
            val freq = HashMap<Char, Int>()
            var maxFreq = 0
            for(j in i until s.length) {
                freq[s[j]] = freq.getOrDefault(s[j], 0) + 1
                maxFreq = maxOf(maxFreq, freq[s[j]]!!)
                if(j - i + 1 - maxFreq <= k) {
                    max = maxOf(max,  j - i +1)
                }
            }
        }
*/

 /*
        for(c in s.toSet()) {
            var l = 0
            var cc = 0 // c count
            for(r in s.indices) {
                if(s[r] == c) {
                    cc++
                }
                while (r - l + 1 - cc > k) {
                    if(s[l] == c) {
                       cc--
                    }
                    l++
                }
                max = maxOf(max, r - l + 1)
            }

        }
*/

        val freq = HashMap<Char, Int>()
        var l = 0
        var maxF = 0

        for (r in s.indices) {
            freq[s[r]] = freq.getOrDefault(s[r], 0) + 1
            maxF = maxOf(maxF, freq[s[r]]!!)


            while (r - l + 1 - maxF > k) {
                freq[s[l]] = freq[s[l]]!! - 1
                l++
            }

            max = maxOf(max, r - l + 1)
        }


        return max

    }
}
