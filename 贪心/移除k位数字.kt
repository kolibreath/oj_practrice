import java.lang.StringBuilder
import java.util.*

class 移除k位数字 {
    class Solution {
        fun removeKdigits(num: String, k: Int): String {
            val stack = Stack<Char>()
            var counter = k
            for(n in num) {
                while (stack.isNotEmpty() && counter != 0 && stack.peek() > n) {
                    counter--
                    stack.pop()
                }
                stack.push(n)
            }

            while(counter-- > 0) stack.pop()

            var first = false
            val builder = StringBuilder()
            for(item in stack) {
                if(item != '0') first = true
                if(first) builder.append(item)
            }
            val result = builder.toString()
            return if(result.isEmpty()) "0" else result
        }
    }
}

fun main() {
    val solution = 移除k位数字.Solution()
    val m = 6
    val k = 3
    val builder = StringBuilder()
    for(i in 0 until m) builder.append(Random().nextInt(10))
    println(builder.toString())
    println(solution.removeKdigits("9876543", 2))
}