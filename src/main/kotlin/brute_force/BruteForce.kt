package brute_force

import java.util.StringJoiner

fun main(args: Array<String>) {
    println(
        BruteForce.matchStringPattern(
            "I Love Programming and I do Programming",
            "and"
        )
    )
}

class BruteForce {

    companion object {
        /**
         * String matching problem
         */
        fun matchStringPattern(text: String, stringToBeMatched: String): Int {
            var length = text.length
            val sLength = stringToBeMatched.length
            for (i in 0..(length - sLength)) {
                var j = 0
                while ((j < sLength) && (text[i + j] == stringToBeMatched[j])) {
                    j++
                }
                if (j == sLength) {
                    return i
                }
            }
            return -1
        }

        /**
         * Two Sum problem
         */
        fun twoSum(nums: IntArray, target: Int): IntArray {
            var first: Int
            var second: Int
            var temp: Int

            for (i in 0 until nums.size - 1) {
                first = i
                temp = target - nums[i]
                for (j in (i + 1) until nums.size) {
                    if (temp == nums[j]) {
                        second = j
                        return intArrayOf(first, second)
                    }
                }
            }
            throw IllegalStateException("Not found")
        }
    }

}