
import kotlin.collections.ArrayList


class 验证二叉树{
    class Solution {
        fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
            val graph: Array<ArrayList<Int>> = Array(n){ArrayList<Int>()}

            val indegree = IntArray(n)
            val outdegree = IntArray(n)

            for (i in 0 until n) {
                if (leftChild[i] != -1) {
                    outdegree[i]++
                    indegree[leftChild[i]]++
                    graph[i].add(leftChild[i])
                }
                if (rightChild[i] != -1) {
                    outdegree[i]++
                    indegree[rightChild[i]]++
                    graph[i].add(rightChild[i])
                }
            }
            //找到入度为0的节点作为根节点 如果存在入度不为0的节点就返回false
            var start = 0
            for (i in 0 until n) {
                if (indegree[i] == 0) {
                    start = i
                }
                if (indegree[i] > 1) return false
            }
            val visited = IntArray(n)
            val dfs = dfs(start, graph, visited)
            return dfs && count == n
        }

        private var count = 0
        private fun dfs(start: Int, graph: Array<ArrayList<Int>>, visited: IntArray): Boolean {
            if (visited[start] == -1) return false
            count++
            visited[start] = -1
            val neighbors = graph[start]
            var flag = true
            for (neighbor in neighbors) {
                val f = dfs(neighbor, graph, visited)
                flag = f && flag
            }
            return flag
        }
    }
}