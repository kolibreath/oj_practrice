class Solution {
    fun readBinaryWatch(num: Int): List<String> {
        val list = ArrayList<String>()
        for (i in 0 until 12)
            for (j in 0 until 60)
                if( Integer.bitCount(i) + Integer.bitCount(j) == num){
                    val string = String.format("%d:%02d",i,j);
                    list.add(string)
                }
        return list
    }
}