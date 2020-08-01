class 连通网络的操作次数 {
    class UnionFind(n:Int) {
        private val parent = IntArray(n) { it }

        private fun find(x: Int): Int {
            var x_ = x
            while (x_ != parent[x_]) {
                parent[x_] = parent[parent[x_]]
                x_ = parent[x_]
            }
            return x_
        }

        fun union(x: Int, y: Int):Int {
            val rootX = find(x)
            val rootY = find(y)
            return if(rootX == rootY)
                    0
                else {
                    parent[rootX] = rootY
                    1
            }
        }


    }

    class Solution {
        fun makeConnected(n: Int, connections: Array<IntArray>): Int {
            if(n - 1> connections.size) return -1
            val unionFind = UnionFind(n)
            var count = 0
            for (connection in connections){
                count += unionFind.union(connection[0], connection[1])
            }
            return if(n - count - 1 < 0) -1 else n -count - 1
        }
    }
}