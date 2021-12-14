class 有效三角形的个数 {
    class Solution {
        fun triangleNumber1(nums: IntArray): Int {
            var counter = 0
            val sorted = nums.sorted()
            if(sorted.size < 3) return 0
            for(i in 0..(sorted.size - 3)) {
                val min = sorted[i]
                for(j in (i + 1)..(sorted.size - 2)) {
                    val mid = sorted[j]
                    for(k in (j + 1)..(sorted.size - 1)) {
                        val max = sorted[k]
                        if((min + mid) > max && (max - min) < mid) counter ++
                    }
                }
            }
            return counter
        }

        fun triangleNumber(num: IntArray): Int {
            var counter = 0
            if(num.size < 3) return counter
            val nums = num.sorted()
            for(i in nums.indices) {
                for (j in i + 1 until nums.size) {
                    var left = j + 1
                    var right = nums.size - 1
                    var k = j
                    val cmax = nums[i] + nums[j]
                    while(left <= right) {
                        val mid = (left + right) / 2
                        if(nums[mid] < cmax){
                            left = mid + 1
                            k = mid
                        } else {
                            right = mid - 1
                        }
                    }
                    counter += k - j
                }
            }
            return counter
        }

    }
}

fun main() {
    val solution = 有效三角形的个数.Solution()
    val nums = intArrayOf(7,0,0,0)
    println(solution.triangleNumber(nums))
}