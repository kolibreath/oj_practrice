class StrStrr {
    class Solution {
        fun strStr(haystack: String, needle: String): Int {
            var i = 0
            var j =0

            while(i < haystack.length){
                if(haystack[i] == needle[j]) {
                    var w = i
                    j = 0
                    while (j < needle.length) {
                        if(haystack[w] != needle[j]){
                            break
                        }

                        j++
                        w++
                    }
                    if(w - i == needle.length)
                        return i
                }
                i++
            }
            return -1
        }
    }
}