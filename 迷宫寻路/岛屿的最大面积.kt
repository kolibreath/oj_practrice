class 岛屿的最大面积 {
    class Solution {
        private var height = 0
        private var width = 0
        private lateinit var grid: Array<IntArray>
        private val dirs = listOf(Pair(-1,0), Pair(1,0), Pair(0,1), Pair(0,-1))

        private val list = ArrayList<Int>()
        private var count = 0

        private fun dfs(x:Int, y:Int){
            if(x < 0 || x >= height || y < 0 || y >= width) return
            if(grid[x][y] != 1) return
            grid[x][y] = -1
            count ++
            for (dir in dirs)
                dfs(x + dir.first, y + dir.second)
        }

        fun maxAreaOfIsland(grid: Array<IntArray>): Int {
            this.height = grid.size
            this.width = grid[0].size
            this.grid = grid

            for (i in 0 until  height)
                for (j in 0 until width){
                    if(grid[i][j] != 1) continue
                    dfs(i,j)
                    list.add(count)
                    count = 0
                }
            return if(list.isEmpty()) 0 else list.max()!!
        }
    }
}