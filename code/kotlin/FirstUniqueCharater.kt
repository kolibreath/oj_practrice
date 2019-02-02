class FirstUniqueCharater{
    class Solution {
        fun firstUniqChar(s: String): Int {
            if( s == "")
                return -1
            val map = IntArray(26) {0}
            s.toCharArray().forEach { map[it.toInt() - 97]++ }
            for( i in 0 until s.length )
                if(map[s[i].toInt() - 97] == 1)
                    return i
            return -1
        }
    }
}