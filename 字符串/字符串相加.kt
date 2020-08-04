import java.lang.StringBuilder

class 字符串相加 {
    class Solution {
        fun addStrings(num1: String, num2: String): String {
            var i = num1.length - 1;
            var j = num2.length - 1
            var carry = 0
            val result = StringBuilder("")
            while(i >= 0 || j >= 0 || carry != 0){
                val x = if(i >= 0) num1[i].toInt() - 48 else 0
                val y = if(j >= 0) num2[j].toInt() - 48 else 0
                val sum = x + y + carry
                carry = sum / 10
                result.append(sum % 10)
                i--;j--
            }
            return result.reversed().toString()
        }
    }
}