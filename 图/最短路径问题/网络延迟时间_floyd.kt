import kotlin.math.max
import kotlin.math.min

class 网络延迟时间_floyd {
    class Solution{
        fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {
            //不能使用Int.MAX_VALUE 容易溢出
            val graph = Array(N+1){IntArray(N+1){0x3f3f3f3f}}
            for (i in 0..N) graph[i][i] = 0
            for (time in times)
                graph[time[0]][time[1]] = time[2]

            for (k in 1..N)
                for (i in 1..N)
                    for (j in 1..N)
                        graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

            var ans = 0
            for (i in 1..N) ans = max(ans, graph[K][i])
            return if (ans == 0x3f3f3f3f) -1 else ans
        }
    }

}