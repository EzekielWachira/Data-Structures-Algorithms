package challenges.graphs.topoplogical_sort

fun main() {
    println(ContainsDuplicate().containsDuplicate(intArrayOf(1, 2, 4, 5, 3, 7, 7, 2)))
}

class ContainsDuplicate {

    fun containsDuplicate(numbers: IntArray): Boolean {
        val resultMap = hashMapOf<Int, Int>()
        for (i in numbers.indices) {
            if (resultMap.containsKey(numbers[i])) {
                return true
            }
            resultMap[numbers[i]] = i
        }
        return false
    }
}