class 最大交换 {
    class Solution {
        fun maximumSwap(num: Int): Int {
            val str = num.toString()
            for(i in str.indices) {
                val index = findMax(str, i)
                val max = str[index]
                if(max == str[i]) continue
                else {
                    val chars = str.toCharArray()
                    val temp = chars[i]
                    chars[i] = max
                    chars[index] = temp
                    return String(chars).toInt()
                }
            }
            return num
        }

        private fun findMax(str: String, start: Int): Int {
            var max = str[start]
            var index = start
            for(i in start until str.length) {
                if(str[i] >= max) {
                    max = str[i]
                    index = i
                }
            }
            return index
        }
    }
}

fun main(){
    val solution = 最大交换.Solution()
    val nums = 1993
    println(solution.maximumSwap(nums))
}