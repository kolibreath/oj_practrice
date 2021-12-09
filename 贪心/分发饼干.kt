class 分发饼干 {
    class Solution {
        fun findContentChildren(g: IntArray, s: IntArray): Int {
            if(s.isEmpty()) return 0
            val gs = g.sortedDescending()
            val ss = s.sortedDescending()

            var index = 0
            for(item in gs) {
                if(index >= ss.size) break
                if(item <= ss[index]) index++
            }
            return index
        }
    }
}

fun main() {
    val solution = 分发饼干.Solution()
    val g = intArrayOf(1,2,3)
    val s = intArrayOf(3)
    println(solution.findContentChildren(g,s))
}