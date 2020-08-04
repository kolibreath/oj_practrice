import java.util.*

class 有效的括号 {
    class Solution {
        fun isValid(s: String): Boolean {
            val stack = LinkedList<Char>()
            for(char in s){
                when(char){
                    '(','[','{' -> {stack.push(char)}
                    ')' -> if(stack.peek() != '(') return false else stack.pop()
                    ']' -> if(stack.peek() != '[') return false else stack.pop()
                    '}' -> if(stack.peek() != '{') return false else stack.pop()
                }
            }
            return stack.isEmpty()
        }
    }
}