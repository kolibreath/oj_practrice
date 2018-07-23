import java.util.*

class SolutionPlusOne {

    var a = IntArray(3,{0})

    fun plusOne(digits: IntArray): IntArray {
        if(digits == null || digits.size == 0 )
            return IntArray(0)


        var value = 0
        var time  = 1
        for (i in digits.indices.reversed()) {
            value += digits[i]*time
            time *= 10
        }

        value += 1

        val list = ArrayList<Int>()
        while(value >0){
            list.add(value%10)
            value /= 10
        }
        list.reverse()

        return list.toIntArray()
    }
}