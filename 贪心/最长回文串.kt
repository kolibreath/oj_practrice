import java.lang.StringBuilder
import java.util.*

class 最长回文串 {
    class Solution {
        fun longestPalindrome(str: String): Int {
            if(str == "") return 0
            val bigcase = IntArray(26) {0}
            val smallcase = IntArray(26) {0}
            for(s in str) {
                if(s.isUpperCase()) {
                    bigcase[s-'A'] ++
                } else {
                    smallcase[s-'a']++
                }
            }
            // 找big和small中最大的奇数
            var result = 0
            var max = 0
            for(i in 0 until 26) {
                val big = bigcase[i]
                val small = smallcase[i]
                result += big / 2 * 2 + small / 2 * 2
                // 如果当前的字符串还可以添加回文中心
                if(result % 2 == 0 && ( big%2 == 1 || small % 2 == 1)) result ++
            }
            return result + max
        }
    }
}

fun main() {
    val k = 10
    val str = CharArray(k) {
        if(Random().nextInt(10) % 2 == 0 )
            (Random().nextInt(26) + 'A'.toInt()).toChar()
        else
            (Random().nextInt(26) + 'a'.toInt()).toChar()
    }
    val builder = StringBuilder()
    str.forEach { builder.append(it) }
    val string = builder.toString()
    println(string)
    val solution = 最长回文串.Solution()
    println(solution.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"))
}