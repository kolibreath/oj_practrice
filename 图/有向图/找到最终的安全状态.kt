class 找到最终的安全状态 {
    class Solution {
        fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
            val N = graph.size
            val color = IntArray(N) { 0 }
            val result = ArrayList<Int>()
            for (i in 0 until N)
                if(dfs(i,color, graph)) result.add(i)
            return result
        }

        //white 0 (unvisited) gray 1 (visited) black 2 (safe)
        fun dfs(start:Int , color: IntArray, graph: Array<IntArray>):Boolean{
            if(color[start] == 1 ) return false
            if(color[start] == 2) return true

            color[start] = 1
            val neighbors = graph[start]
            for(neighbor in neighbors){
                val value = dfs(neighbor, color, graph)
                if(!value) return false
            }
            color[start] = 2
            return true
        }
    }
}