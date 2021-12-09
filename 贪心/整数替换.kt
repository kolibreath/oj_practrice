import kotlin.math.min
import kotlin.system.measureTimeMillis

class 整数替换 {
    class Solution {
        fun integerReplacement(n: Int): Int {
            // 如果是2的幂
            if (n and (n - 1) == 0) {
                var counter = 0
                while(1.shl(counter) != n) counter ++
                return counter
            }
            return if (n % 2 == 0)
                1 + integerReplacement(n/2)
            else
                2 + min(integerReplacement(n/2), integerReplacement(n/2+1))
        }

        // 加上记忆化
        val map = HashMap<Int, Int>()
        fun integerReplacement1(n: Int): Int {
            // 如果是2的幂
            if (n and (n - 1) == 0) {
                var counter = 0
                while (1.shl(counter) != n) counter++
                return counter
            }
            if (map.containsKey(n).not()) {
                if (n % 2 == 0) {
                    map[n] = 1 + integerReplacement1(n / 2)
                }
                else {
                    map[n] = 2 + min(integerReplacement1(n / 2), integerReplacement1(n / 2 + 1))
                }
            }
            return map[n]!!
        }

    }
}

fun main() {
    val solution = 整数替换.Solution()
    println(measureTimeMillis {
        println(solution.integerReplacement(20000))
    })

    println(measureTimeMillis {
        println(solution.integerReplacement1(20000))
    })
}