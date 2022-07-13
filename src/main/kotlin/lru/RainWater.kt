package lru

import kotlin.math.max

fun main() {
    println(RainWater.trap(intArrayOf(4,2,0,3,2,5)))
}

class RainWater {
    companion object {
        fun trap(height: IntArray): Int {
            if (height.isEmpty()) return 0

            var left = 0
            var right = height.size - 1
            var leftMax = height[left]
            var rightMax = height[right]
            var result = 0

            while (left < right) {
                if (leftMax < rightMax) {
                    left += 1
                    leftMax = max(leftMax, height[left])
                    result += leftMax - height[left]
                } else {
                    right -= 1
                    rightMax = max(rightMax, height[right])
                    result += leftMax - height[right]
                }
            }

            return result
        }
    }
}