class IsPanlidrome{
    class Solution {
        fun isPalindrome(string: String): Boolean {
           
            val s = string.toLowerCase()
            var high = s.length -1
            var low = 0
            while(low < high ){
                var lowChar = s[low]
                var highChar = s[high]

                while(!lowChar.isLetterOrDigit()){
                    low++
                    if(low >= string.length)
                        return true
                    lowChar = s[low]
                }

                while(!highChar.isLetterOrDigit() ){
                    high--
                    if(high < 0)
                        return true
                    highChar = s[high]
                }

                if(lowChar != highChar){
                    return false
                }
                low++
                high--

            }

            return true
        }
    }
}