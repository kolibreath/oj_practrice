class 等式方程的可满足性 {
    class UnionFind(n:Int){
        private val parent = IntArray(n){it}
//        隔代压缩
        private fun find(x:Int):Int{
            var _x = x
            while(_x != parent[_x]){
                parent[_x] = parent[parent[_x]]
                _x = parent[_x]
            }
            return _x
        }

//        合并两个子集
        fun union(x:Int, y:Int) {
            val rootX = find(x)
            val rootY = find(y)
            parent[rootX] = rootY
        }

        fun isConnected(x:Int, y:Int):Boolean = find(x) == find(y)
    }

    class Solution {
        fun equationsPossible(equations: Array<String>): Boolean {
            val unionFind = UnionFind(26)
            for (equation in equations) {
                if (equation[1] == '=') {
                    val index1 = equation[0] - 'a'
                    val index2 = equation[3] - 'a'
                    unionFind.union(index1, index2)
                }
            }
            for (equation in equations) {
                if(equation[1] == '!'){
                    val index1 = equation[0] - 'a'
                    val index2 = equation[3] - 'a'
                    if(unionFind.isConnected(index1, index2)) return false
                }
            }
            return true
        }
    }
}