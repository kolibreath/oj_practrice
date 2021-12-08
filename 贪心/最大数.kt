import java.lang.StringBuilder
import kotlin.math.min

class 最大数 {
    class Solution {
        fun largestNumber(nums: IntArray): String {
            if(nums.size == 1) return nums[0].toString()
            val sorted = nums.sortedWith(Comparator { o1, o2 ->
                val str1 = o1.toString()
                val str2 = o2.toString()

                val con1 = str1 + str2
                val con2 = str2 + str1
                for(i in con1.indices)
                    if(con1[i] > con2[i]) return@Comparator 1
                    else if(con1[i] == con2[i]) continue
                    else return@Comparator -1
                1
            })
            var flag = true
            for(item in sorted) {
                if (item != 0){
                    flag = false
                    break
                }
            }
            if(flag) return "0"

            val stringBuilder = StringBuilder()
            for(item in sorted.asReversed()) stringBuilder.append(item)
            return stringBuilder.toString()
        }


    }
}

fun main(){
    val solution = 最大数.Solution()
    println(solution.largestNumber(intArrayOf(0,0)))
}