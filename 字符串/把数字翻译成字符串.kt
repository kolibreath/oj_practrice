class 把数字翻译成字符串 {
    class Solution {
        fun translateNum(num: Int): Int {
            return dfs(num.toString(), 0)
        }

        // dfs -> num[start] 可以被解析的情况总数
        private fun dfs(num: String, start: Int): Int {
            if (start >= num.length) return 1
            if (num[start] == '0') return dfs(num, start + 1)
            // 1
            if (num[start] == '1') {
                // 单独处理这个1
                var res = dfs(num, start + 1)
                // 和后面的一个数一起被处理
                if (start + 1 < num.length){
                    val temp = dfs(num, start + 2)
                    res += temp
                }

                return res
            }
            // 2
            if (num[start] == '2') {
                // 当前的2可以被单独处理
                var res = dfs(num, start + 1)
                // 数字小于等于26时可以被解析
                if (start + 1 < num.length && num[start + 1] < '6')
                    res += dfs(num, start + 2)
                return res
            }
            // 3 - 9
            return dfs(num, start + 1)
        }
    }
}

fun main() {
    val solution = 把数字翻译成字符串.Solution()
    val num = 1024
    println(solution.translateNum(num))
}