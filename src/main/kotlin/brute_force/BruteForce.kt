package brute_force

fun main(args: Array<String>) {
    //Test string patter matcher
    println(
        BruteForce.matchStringPattern(
            "I Love Programming and I do Programming",
            "and"
        )
    )

    //Test two sum through bruteforce
//    println(
        BruteForce.twoSumUsingHashMap(intArrayOf(-4, 2,7,11,15), 11).forEach { print(it) }
//    )
}

class BruteForce {

    override fun toString(): String {
        return BruteForce.toString()
    }

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

        fun twoSumUsingHashMap(nums: IntArray, target: Int): IntArray {
            val result = hashMapOf<Int, Int>()
            var diff: Int
            for (i in nums.indices) {
                diff = target - nums[i]
                if (result.containsKey(diff)) {
                    return intArrayOf(result[diff]!!, i)
                }
                result[nums[i]] = i
            }
            throw IllegalStateException("Not found")
        }
    }

}