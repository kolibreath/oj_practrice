class 汉明距离 {
    class Solution {
        fun hammingDistance(x: Int, y: Int): Int {
            val result = x xor  y
            var mask = 1
            var count = 0
            for (i in 0..31){
                if((mask and result) != 0) count++
                mask = mask.shl(1)
            }
            return count
        }
    }
}