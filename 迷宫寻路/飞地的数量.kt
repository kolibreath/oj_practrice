class 飞地的数量 {
    class Solution {
        private var height = 0
        private var width = 0

        private lateinit var grid:Array<IntArray>
        private var count = 0
        private val dirs = listOf(Pair(-1,0),Pair(1,0),Pair(0,-1),Pair(0,1))

        fun dfs(x:Int, y:Int, flag:Boolean){
            if(x < 0 || x >= height || y < 0 || y >= width) return
            if(grid[x][y] != 1) return

            grid[x][y] = -1
            if(flag) count++
            for (dir in dirs){
                dfs(x + dir.first , y + dir.second,flag)
            }
        }

        fun numEnclaves(A: Array<IntArray>): Int {
            this.grid = A
            this.height = grid.size
            this.width = grid[0].size

            for (i in 0 until width){
                dfs(0, i, false)
                dfs(height-1,i, false)
            }

            for (i in 0 until  height){
                dfs(i, 0, false)
                dfs(i,width-1,false)
            }


            for (i in 0 until height)
                for (j in 0 until width){
                    if(grid[i][j] != 1) continue
                    dfs(i,j, true)
                }
            return count
        }
    }
}