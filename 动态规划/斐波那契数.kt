class 斐波那契数 {
    class Solution {
        fun fib(n: Int): Int {
            if (n <= 1) return n
            val dp = IntArray(n + 1){0}
            dp[0] = 0
            dp[1] = 1
            for(i in 2..n) {
                dp[i] = dp[i-1] + dp[i-2]
            }
            return dp[n]
        }
    }
}

fun main() {
    val solution = 斐波那契数.Solution()
    val n = 0
    println(solution.fib(n))
}