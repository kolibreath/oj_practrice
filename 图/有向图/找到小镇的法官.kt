class 找到小镇的法官{
    class Solution {
        fun findJudge(N: Int, trust: Array<IntArray>): Int {
            val outs = IntArray(N+1)
            val ins  = IntArray(N+1)

            for (item in trust){
                outs[item[0]] ++
                ins[item[1]]++
            }

            for (i in 1..N)
                if (ins[i] == N - 1 && outs[i] == 0) return i
            return -1
        }
    }
}