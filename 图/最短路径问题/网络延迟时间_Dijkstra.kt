import kotlin.math.min

class 网络延迟时间_Dijkstra {
    class Solution {
        fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {
            val graph = HashMap<Int, ArrayList<Pair<Int,Int>>>()
            //生成带权图
            for (time in times)
                graph[time[0]] = graph.getOrDefault(time[0],ArrayList()).apply { add(Pair(time[1], time[2])) }
            //从1开始到N
            val visited = BooleanArray(N+1){false}
            //初始化所有点距离K的距离为无限大 但是 K到自身的距离为0
            val distance  = HashMap<Int,Int>().apply {
                for (i in 1..N) {
                    if(i == K) put(i, 0)
                    else put(i, Int.MAX_VALUE)
                }
            }

            //进行单源最短路径搜索
            while(true){
                var start = -1
                var startDistance = Int.MAX_VALUE
                //搜索现有的距离K最短的起点
                for (i in 1..N){
                    if(!visited[i] && distance[i]!! < startDistance){
                        start = i
                        startDistance = distance[i]!!
                    }
                }

                //如果start 仍然等于 -1 说明所有节点已经访问完成
                if(start == -1) break

                visited[start] = true
                //访问这个节点的所有邻边
                if(graph.keys.contains(start)){
                    graph[start]!!.forEach {
                        //it = [neighbor, weight]
                        //k -> neighbor = min (k -> neighbor, k -> start + start -> neighbor)
                        distance[it.first] = min(distance[it.first]!!, distance[start]!! + it.second )
                    }
                }
            }

            var ans  = 0
            for (dist in distance.values){
                //存在不连通的点
                if(dist == Int.MAX_VALUE) return -1
                if(ans < dist) ans = dist
            }
            return ans
        }
    }
}