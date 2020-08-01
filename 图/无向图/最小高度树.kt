import java.util.*
import kotlin.collections.ArrayList

class 最小高度树{
    class Solution {
        fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
            if(edges == null || edges.isEmpty()) return ArrayList<Int>().apply{add(0)}
            val graph = Array<ArrayList<Int>>(n){ ArrayList() }
            val degree = IntArray(n){0}

            for (edge in edges){
                degree[edge[0]]++;degree[edge[1]]++
                graph[edge[0]].add(edge[1])
                graph[edge[1]].add(edge[0])
            }

            //第一轮搜索度为1的节点
            val queue = LinkedList<Int>()
            for ((index, d) in degree.withIndex())
                if(d == 1)
                    queue.add(index)

            var result = LinkedList<Int>()
            while(!queue.isEmpty()){
                result = LinkedList()

                val size = queue.size

                for (i in 0 until size){
                    val cur = queue.poll()
                    result.add(cur)

                    for (neighbor in graph[cur]){
                        degree[neighbor]--
                        if(degree[neighbor] == 1)
                            queue.add(neighbor)
                    }
                }
            }
            return result
        }
    }
}