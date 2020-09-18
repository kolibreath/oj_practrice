import kotlin.math.sqrt

class 二进制表示中质数个计算置位 {
    class Solution {
        fun isPrime(n:Int):Boolean {
            if( n == 1) return false
            for (i in 2..sqrt(n.toDouble()).toInt())
                if( n % i == 0) return false
            return true
        }

        fun countPrimeSetBits(L: Int, R: Int): Int {
            var count = 0
            for ( i in L..R) {
                if(isPrime(Integer.bitCount(i))) count ++
            }
            return count
        }
    }
}