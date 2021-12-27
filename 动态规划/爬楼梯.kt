class 爬楼梯 {
    class Solution {
        fun climbStairs(n: Int): Int {
            if (n <= 2) return n
            val dp = IntArray(n+1)
            dp[1] = 1
            dp[2] = 2
            for(i in 3 .. n) dp[i] = dp[i-1] + dp[i-2]
            return dp[n]
        }
    }
}

fun main() {
    val solution = 爬楼梯.Solution()
    val n = 2
    println(solution.climbStairs(n))
}