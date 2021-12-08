import java.util.*

class 递增的三元子序列 {
    class Solution {
        fun increasingTriplet(nums: IntArray): Boolean {
            var one = Int.MAX_VALUE
            var two = Int.MAX_VALUE
            for(three in nums) {
                when {
                    three <= one -> one = three
                    three <= two -> two = three
                    else -> return true
                }
            }
            return false
        }
    }
}

fun main() {
    val solution = 递增的三元子序列.Solution()
    val k = 8
    val nums = IntArray(k) { Random().nextInt(10)}
    nums.forEach { print("$it ") }
    println(solution.increasingTriplet(nums))
}