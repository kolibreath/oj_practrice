class ReverseInteger{
    class Solution {
        fun reverse(x: Int): Int {
            val string = x.toString().toCharArray()
            var low = if(string[0] == '-')  1 else 0
            var high = string.size -1

            while(low < high){
                val temp = string[low]
                string[low] = string[high]
                string[high] = temp

                low++
                high--
            }

            return if( String(string).length >= 10){
                0
            }else{
               String(string).toInt()
            }
        }
    }
}