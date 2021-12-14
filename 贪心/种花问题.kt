class 种花问题 {
    class Solution {
        fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
            if (n == 0) return true
            var cp = n
            for(i in flowerbed.indices) {
                if(flowerbed[i] == 1) continue
                val left = if(i == 0) true else flowerbed[i-1] != 1
                val right = if(i == flowerbed.size-1) true else flowerbed[i+1] != 1
                if(left && right) {
                    cp --
                    flowerbed[i] = 1
                }
                if(cp == 0) break
            }
            return cp == 0
        }
    }
}

fun main() {
    val solution = 种花问题.Solution()
    println(solution.canPlaceFlowers(intArrayOf(0,0,1,0,0), 1))
}