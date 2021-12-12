class 快速幂 {
    class Solution {
        fun myPow(x: Double, n: Int): Double {
           return if (n >= 0)
               quickPow(x, n.toLong())
           else
               1.0 / quickPow(x, -(n).toLong())
         }

        fun quickPow(x: Double, n: Long): Double {
            var conx = x
            var nc = n
            var result = 1.0
            while(nc != 0L) {
                if(nc%2==1L) {
                    result *= conx
                }
                conx *= conx
                nc /= 2
            }
            return result
        }
    }
}

fun main() {
    val solution = 快速幂.Solution()
    println(solution.myPow(2.0, -2147483648))
}