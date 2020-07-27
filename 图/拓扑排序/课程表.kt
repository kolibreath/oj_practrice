class 课程表 {
    class Solution {
        //visited == -1 当前节点已经访问完成并且图中没有出现回环
        //visited == 0 当前节点没有进行访问过
        //visited == 1 当前节点已经在本轮dfs中访问过 再次访问即出现回环
        private fun dfs(graph:Array<ArrayList<Int>>, cur:Int,visited:Array<Int>):Boolean{
            if(visited[cur] == 1) return false
            if(visited[cur] == -1) return true
            visited[cur] = 1
            for (neighbor in graph[cur])
                //这样写正确吗？
//                return dfs(graph, neighbor, visited)
                if(!dfs(graph, neighbor,visited)) return false
            visited[cur] = -1
            return true
        }

        fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            val graph = Array<ArrayList<Int>>(numCourses){ ArrayList() }
            for (course in prerequisites)
                graph[course[1]].add(course[0])

            val visited = Array(numCourses){0}

            for (course in 0 until numCourses) {
                if(visited[course] != 0) continue
                if (!dfs(graph, course, visited)) return false
            }
            return true
        }
    }
}