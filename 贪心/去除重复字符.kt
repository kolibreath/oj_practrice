import java.util.*

class 去除重复字符 {

    class Solution {
        fun removeDuplicateLetters(s: String): String {
            // 扫描一遍整体的s 获取每一个字符的出现次数
            val count = IntArray(26){0}
            s.forEach { count[it-'a']++ }
            // 构建hash 表示是否在stack中出现
            val hash = IntArray(26) {0}
            val stack = Stack<Char>()
            for(char in s) {
                // 必须先要判断当前的char能否加入stack
                if (hash[char - 'a'] == 0) {
                    // 清除可以清除的部分
                    while (stack.isNotEmpty() && stack.peek() > char && count[stack.peek() - 'a'] > 1) {
                        count[stack.peek() - 'a']--
                        hash[stack.peek() - 'a']--
                        stack.pop()
                    }
                    // 当清除完成加入这个char
                    stack.push(char)
                    hash[char - 'a']++
                } else count[char - 'a']--
            }
            val builder = StringBuilder()
            for(char in stack) builder.append(char)
            return builder.toString()
        }
    }
}

fun main() {
    val solution = 去除重复字符.Solution()

    val k = 10
    val builder = StringBuilder()
    for(i in 0 until  k) {
        builder.append((Random().nextInt(26) + 'a'.toInt()).toChar())
    }
    builder.toString()
    println("abacb")
    println(solution.removeDuplicateLetters("abacb"))
}