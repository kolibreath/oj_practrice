import java.util.*
import kotlin.collections.HashMap

class 将整数按照权重排序 {
    class Solution {
        private val map = HashMap<Int,Int>()
        private fun dfs(number:Int) :Int{
            if (map.keys.contains(number)) return map[number]!!
            if (number == 1) {
                map[number] = 1
                return 1
            }
            return if(number % 2 == 1){
                map[number] = dfs(number * 3 + 1) + 1
                map[number]!!
            }else{
                map[number] = dfs(number /2 ) + 1
                map[number]!!
            }
        }

        fun getKth(lo: Int, hi: Int, k: Int): Int {
            val list = Array(hi - lo + 1){it + lo}
            for (item in list ) dfs(item)

            val comparator = Comparator<Int> { o1, o2 ->
                if(map[o1] != map[o2]) map[o1]!! - map[o2]!!
                else o1 - o2
            }

            return list.sortedWith(comparator)[k-1]
        }
    }
}