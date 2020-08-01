class 冗余连接 {
    class UnionFind(n:Int){
        private val parent = IntArray(n){it}

        fun find(x:Int):Int{
            var x_ = x
            while(x_ != parent[x_]){
                parent[x_] = parent[parent[x_]]
                x_ = parent[x_]
            }
            return x_
        }

        fun union(x:Int, y:Int){
            val rootX = find(x)
            val rootY = find(y)
            parent[rootX] = rootY
        }

        fun isConnected(x:Int, y:Int):Boolean = find(x) == find(y)
    }
    class Solution {
        fun findRedundantConnection(edges: Array<IntArray>): IntArray {
            var record = IntArray(0)
            val unionFind = UnionFind(1001)
            for (edge in edges){
                if(!unionFind.isConnected(edge[0], edge[1])) unionFind.union(edge[0], edge[1])
                else record = edge
            }
            return record
        }
    }
}