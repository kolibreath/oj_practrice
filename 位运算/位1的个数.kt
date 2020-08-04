class 位1的个数{
    class Solution {
        // you need treat n as an unsigned value
        fun hammingWeight(n:Int):Int {
            var mask = 1
            var bits = 0
            var n_ = n
            for (i in 0..31){
                if( (n_ and mask) != 0) bits++
                mask = mask.shl(1)
            }
            return bits
        }
    }
}