class 统计参与通信的服务器 {
    class Solution {
        private val dirs = listOf(Pair(1,0), Pair(-1, 0), Pair(0,1), Pair(0,-1))
        private var count = 0

        private fun dfs(grid: Array<IntArray>, x:Int, y:Int){
            val width = grid.size
            val height = grid[0].size

            if(x < 0 || x >= width || y < 0 || y >= height || grid[x][y] != 1 )
                return
            //对一行或者一列进行扫描
            var line1 = false
            var line2 = false
            for (i in 0 until height){
                if(i == y) continue
                if(grid[x][i] == 1 || grid[x][i] == -1){
                    line1 = true
                    break
                }
            }

            for (j in 0 until width){
                if (j == x) continue
                if(grid[j][y] == 1 || grid[j][y] == -1){
                    line2 = true
                    break
                }
            }
            if(line1 || line2) {
                count++
                grid[x][y] = -1
            }

            for (dir in dirs)
                dfs(grid, x + dir.first, y + dir.second)
        }

        fun countServers(grid: Array<IntArray>): Int {
            for (i in grid.indices)
                for (j in grid[0].indices){
                    if(grid[i][j] != 1) continue
                    dfs(grid, i, j)
                }

            return count
        }
    }
}