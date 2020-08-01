class 朋友圈 {
    class UnionFind(n:Int){
        private val parent = IntArray(n){-1}
//        private fun find(x:Int):Int{
//            var _x = x
//            while(_x != parent[_x]){
//                parent[_x] = parent[parent[_x]]
//                _x = parent[_x]
//            }
//            return _x
//        }
//
        private fun find(x:Int):Int{
            if(parent[x] == -1) return x
                return find(parent[x])
        }

        fun union(x:Int, y:Int) {
            val rootX = find(x)
            val rootY = find(y)
            if(rootX != rootY) parent[rootX] = rootY
        }

        fun different():Int{
            var count = 0
            for( i in parent) if(i == -1) count++
            return count
        }
    }

    class Solution {
        fun findCircleNum(M: Array<IntArray>): Int {
            val num = M.size
            val unionFind = UnionFind(num)
            for (i in 0 until num){
                //虽然是无向图但是还是必须得从 0开始 为什么？
                for (j in 0 until  num){
                    if(M[i][j] == 1 && i != j){
                        unionFind.union(i,j)
                    }
                }
            }
            return unionFind.different()
        }
    }
}