package binary_search

import kotlin.math.ceil

class BinarySearch {

    fun binarySearch(num: Int, numbers: Array<Int>, low: Int = 0, high: Int = numbers.size): Int {
        if (numbers.isEmpty())
            return -1

        var start = low
        var end = high

        var mid = (end - start) / 2

        if (numbers[mid] == num)
            return mid

        return if (numbers[mid] > num) {
            end = mid - 1
            binarySearch(num, numbers, start, end)
        } else {
            start = mid + 1
            binarySearch(num, numbers,start, end)
        }

    }

    fun search(num: Int, numbers: Array<Int>, low: Int = -1, high: Int = numbers.size): Int {
        var floorIndex = low
        var ceiling = high

        while ((floorIndex + 1) < ceiling) {
            var distance = ceiling.minus(floorIndex)
            var halfDistance = distance.div(2)
            var guessIndex = floorIndex.plus(halfDistance)

            var guessValue = numbers[guessIndex]

            if (guessValue == num)
                return numbers[guessValue]

            return if (guessValue > num) {
                ceiling = guessIndex
                search(num, numbers, floorIndex, ceiling)
            } else {
                floorIndex = guessIndex
                search(num, numbers, floorIndex, ceiling)
            }
        }

        return -1
    }
}