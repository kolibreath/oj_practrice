class 岛屿数量 {
    class Solution {
        private val dirs = listOf(Pair(-1,0), Pair(1,0), Pair(0,1), Pair(0,-1))

        private fun dfs(grid:Array<CharArray>, x:Int, y:Int){
            val height = grid.size
            val width  = grid[0].size
            if(x < 0 || x >= height || y < 0 || y >= width )
                return
            if(grid[x][y] != '1') return
            grid[x][y] = '-'
            for (dir in dirs)
                dfs(grid, x + dir.first, y + dir.second)

        }
        fun numIslands(grid: Array<CharArray>): Int {
            if(grid.isEmpty() || grid[0].isEmpty()) return 0
            val height = grid.size
            val width  = grid[0].size

            var count = 0
            for (i in 0 until  height)
                for (j in 0 until  width){
                    if(grid[i][j] != '1') continue
                    dfs(grid = grid, x = i, y = j)
                    count ++
                }
            return count
        }
    }
}