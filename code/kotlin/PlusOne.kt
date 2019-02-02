class PlusOne{
    class Solution {
        fun plusOne(digits: IntArray): IntArray {
            digits.reverse()
            var carry = (digits[0] + 1) / 10
            digits[0] = (digits[0] + 1) % 10

            for(i in 1 until digits.size){
                val lastCarry  = carry
                carry = (digits[i] + carry) / 10
                digits[i] = (digits[i] + lastCarry) % 10
            }


            val list = ArrayList<Int>()
            for(num in digits)
                list.add(num)

            if(carry == 1){
                list.add(1)
            }

            return list.reversed().toIntArray()
        }
    }
}