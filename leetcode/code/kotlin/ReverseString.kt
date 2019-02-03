class ReverseString{
    class Solution {
        fun reverseString(s: CharArray): Unit {
            var low = 0
            var high = s.size - 1

            while(low < high){
                val temp = s[low]
                s[low] = s[high]
                s[high] = temp

                low ++
                high --
            }

            for (i in s)
                println(i)
        }
    }
}