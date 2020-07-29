class 课程安排IV {
    class Solution {
//        private fun dfs(start : Int, query: Int, graph: Array<ArrayList<Int>>, visited:BooleanArray):Boolean{
//            if(start == query) return true
//            if(visited[start]) return false
//
//            val neighbors = graph[start]
//            visited[start] = true
//            for (neighbor in neighbors){
//                if(!dfs(neighbor, query, graph, visited)) return false
//            }
//            return false
//        }

        fun checkIfPrerequisite(n: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
//            val graph = Array<ArrayList<Int>>(n){ ArrayList() }
//            for (pre in prerequisites)
//                graph[pre[0]].add(pre[1])
//
//            val result = BooleanArray(queries.size){true}
//
//            for ((index,query) in queries.withIndex() ){
//                if(!dfs(start = query[0], query = query[1], graph = graph, visited = BooleanArray(n){false})) result[index] = false
//            }
//            return result

            val graph = Array<BooleanArray>(n){BooleanArray(n){false}}
            for (pre in prerequisites)
                graph[pre[0]][pre[1]] = true

            //floyd算法本体
            for (k in 0 until n){
                for (i in 0 until n){
                    //假设0 -》4 能不能通过 0->1 解决
                    if(graph[i][k]) {
                        for (j in 0 until n) {
                            graph[i][j] = graph[i][j] || graph[k][j]
                        }
                    }
                }
            }

            val result = BooleanArray(queries.size){false}
            for ((index, query) in queries.withIndex())
                result[index] = graph[query[0]][query[1]]

            return result
        }
    }
}