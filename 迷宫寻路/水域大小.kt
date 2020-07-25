class 水域大小 {
    class Solution {
        private val dirs =  listOf(Pair(-1,0),Pair(1,0),Pair(0,-1), Pair(0,1),Pair(-1,-1),Pair(-1,1),Pair(1,-1),Pair(1,1))
        private var height = 0;
        private var width = 0

        private var cur = 0
        lateinit var land: Array<IntArray>
        fun dfs(i:Int, j:Int){
            if(i < 0 || i >= height || j <0 || j>= width || land[i][j] != 0) return
            land[i][j] = -1
            cur ++
            for (k in 0 until  8) dfs(i + dirs[k].first, j + dirs[k].second)
        }

        fun pondSizes(land: Array<IntArray>): IntArray {
            height = land.size
            width = land[0].size

            this.land = land
            val result = ArrayList<Int>()
            for (i in 0 until  height)
                for (j in 0 until  width){
                    if(land[i][j] != 0) continue
                    dfs(i,j )
                    if(cur == 0) continue
                    result.add(cur)
                    cur = 0
                }

            return result.sorted().toIntArray()
        }
    }
}