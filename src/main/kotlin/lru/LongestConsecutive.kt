package lru

import kotlin.math.max

fun main() {
    println(LongestConsecutive.longestConsecutive(intArrayOf(100,4,200,1,3,2)))
}

class LongestConsecutive {
    companion object {
        fun longestConsecutive(nums: IntArray): Int {
            val numSet = nums.toSet()
            var longest = 0

            for (n in nums) {
                if (!numSet.contains((n - 1))) {
                    var length = 0
                    while (numSet.contains(n + length)) {
                        length += 1
                    }
                    longest = max(longest, length)
                }
            }
            return longest
        }
    }
}