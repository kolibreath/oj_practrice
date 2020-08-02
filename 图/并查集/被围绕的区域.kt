class 被围绕的区域 {
    class Solution {
        private lateinit var visited :Array<IntArray>
        private val dirs = listOf(Pair(1,0), Pair(-1,0), Pair(0,1), Pair(0,-1))
        private lateinit var board: Array<CharArray>

        private fun dfs(visited:Array<IntArray>, x:Int, y:Int, flag:Boolean){
            val width = visited.size
            val height = visited[0].size
            if(x < 0 || x >= width || y < 0 || y > height || visited[x][y] == -1) return
            visited[x][y] = -1

            if (flag)
                board[x][y] = 'X'

            for (dir in dirs)
                dfs(visited, x + dir.first, y + dir.second, flag)

        }

        fun solve(board: Array<CharArray>): Unit {
            if(board.isEmpty() || board[0].isEmpty()) return
            this.board = board

            val width = board.size
            val height = board[0].size

            visited = Array(width){IntArray(height){0} }
            for (i in 0 until width)
                for (j in 0 until height){
                    if(board[i][j] == 'X')
                        visited[i][j] = -1
                }

            //排除边缘
            //上边缘 和 下边缘 visited[0][j] visited[width - 1][j]
            for (j in 0 until  height){
                dfs(visited, 0 , j, false)
                dfs(visited, width - 1 ,j, false)
            }

            for (i in 0 until width){
                dfs(visited, i, 0, false)
                dfs(visited, height -1 ,0, false)
            }

            for (i in 0 until width)
                for (j in 0 until height){
                    if(visited[i][j] == -1) continue
                    dfs(visited, i, j, true)
                }
        }
    }
}