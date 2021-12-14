class 分割数组为连续子序列 {
    class Solution {
        fun isPossible(nums: IntArray): Boolean {
            val container = ArrayList<ArrayList<Int>>()
            for(num in nums) {
                // 当container中存在多个子序列可以添加时
                // 向最短的子序列中添加
                val index = findPossibleShortest(container, num)
                if(index == -1) container.add(arrayListOf(num))
                else container[index].add(num)
            }
            for(list in container) if(list.size < 3) return false
            return true
        }

        fun findPossibleShortest(container: ArrayList<ArrayList<Int>>, num: Int): Int {
            var min = Int.MAX_VALUE
            var index = -1
            for((i, list) in container.withIndex()) {
                if(list.size == 0) continue
                if(list.last() + 1 == num  && list.size < min) {
                    min = list.size
                    index = i
                }
            }
            return index
        }
    }
}

fun main() {
    val solution = 分割数组为连续子序列.Solution()
    val nums = intArrayOf(1,2,3,4,5)
    println(solution.isPossible(nums))
}