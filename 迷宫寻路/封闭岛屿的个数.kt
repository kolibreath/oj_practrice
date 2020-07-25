class 封闭岛屿的个数 {
    class Solution {
        val dirs = listOf(Pair(-1,0), Pair(1,0), Pair(0,-1), Pair(0,1))
        var count = 0
        lateinit var grid: Array<IntArray>
        var height = 0
        var width = 0

        fun dfs(x :Int, y:Int){
            if(x < 0 || x >= height || y < 0 || y>= width) return;
            if(grid[x][y] != 0) return

            grid[x][y] = -1
            for(dir in dirs)
                dfs(x + dir.first, y + dir.second)
        }

        fun closedIsland(grid: Array<IntArray>): Int {
            height = grid.size
            width = grid[0].size
            this.grid = grid

            for (i in 0 until width) {
                dfs(0, i)
                dfs(height - 1, i)
            }

            for (i in 0 until height) {
                dfs(i, 0)
                dfs(i, width - 1)
            }

            for (i in 0 until height)
                for (j in 0 until width) {
                    if (grid[i][j] != 0) continue
                    dfs(i, j)
                    count++
                }
            return count
        }
    }
}