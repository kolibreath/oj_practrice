class 击落砖块 {
    class Solution {
        fun hitBricks(grid: Array<IntArray>, hits: Array<IntArray>): IntArray {
            val m = grid.size; val n = grid[0].size
            val copy = Array(m){ IntArray(n){0} }
            for(i in 0 until m)
                for (j in 0 until n)
                    if (grid[i][j] == 1)
                        copy[i][j] = 1


            // 1. 去除所有要击落的砖块
            for (hit in hits) copy[hit[0]][hit[1]] = 0

            // 2. 统计在初始状态下的并查集
            val size = m * n // size节点
            val unionFind = UnionFind(size + 1)
            // 所有在最上面的节点自动并到虚拟节点size

            fun getIndex(i: Int, j: Int): Int = i * n + j

            for (j in 0 until n)
                if (copy[0][j] == 1)
                    unionFind.union(j, size)

            for (i in 1 until m) {
                for (j in 0 until n) {
                    // 如果上面和左边存在1 说明可以归并到上面一起
                    if (copy[i][j] == 1) {
                        // 如果上方也是砖块
                        if (copy[i - 1][j] == 1) unionFind.union(getIndex(i - 1, j), getIndex(i, j))
                        // 如果左边也是砖块
                        if (j > 0 && copy[i][j - 1] == 1) unionFind.union(getIndex(i, j - 1), getIndex(i, j))
                    }
                }
            }


            val directions = arrayOf(
                intArrayOf(1, 0),
                intArrayOf(-1, 0),
                intArrayOf(0, 1),
                intArrayOf(0, -1)
            )

            fun isValid(nextx: Int, nexty: Int): Boolean {
                if (nextx < 0 || nextx >= m || nexty < 0 || nexty >= n) return false
                return true
            }

            // 3. 还原
            val result = IntArray(hits.size) {0}
            for (i in hits.size - 1 downTo 0) {
                val x = hits[i][0]; val y = hits[i][1]
                // 如果是打没有砖块的网格
                if (grid[x][y] == 0) continue
                // 恢复之前
                val origin = unionFind.getSize(size)
                // 如果是恢复的砖块和顶部相连 要将这个砖块加入并查集
                if (x == 0) unionFind.union(getIndex(0, y), size)
                copy[x][y] = 1
                // 查询加入恢复的砖块后整体的连通情况
                for (dir in directions) {
                    val nextx = x + dir[0]; val nexty = y + dir[1]
                    if (isValid(nextx, nexty) && copy[nextx][nexty] == 1)
                        unionFind.union(getIndex(nextx, nexty), getIndex(x, y))
                }
                // 加入之后的连通情况
                val current = unionFind.getSize(size)
                result[i] = Math.max(0, current - origin - 1)
            }
            return result
        }

        // m n 分别是矩阵的高度和宽度
        class UnionFind(size: Int) {
            private val parents = IntArray(size) {it}  // 当前的节点对应的父节点
            private val size = IntArray(size) {1}      // 当前的节点的根节点对应的树节点个数

            fun union(index1: Int, index2: Int) {
                val head1 = find(index1)
                val head2 = find(index2)
                if (head1 == head2) return
                parents[head1] = head2
                size[head2] += size[head1]
            }

            fun getSize(index: Int): Int  = size[find(index)]

            private fun find(x: Int): Int {
                if (x != parents[x]) {
                    parents[x] = find(parents[x])
                }
                return parents[x]
            }
        }
    }
}

fun main() {
    val solution = 击落砖块.Solution()
    val matrix = arrayOf(
        intArrayOf(0,1,1,1,1),
        intArrayOf(1,1,1,1,0),
        intArrayOf(1,1,1,1,0),
        intArrayOf(0,0,1,1,0),
        intArrayOf(0,0,1,0,0),
        intArrayOf(0,0,1,0,0),
        intArrayOf(0,0,0,0,0),
        intArrayOf(0,0,0,0,0),
        intArrayOf(0,0,0,0,0),



//        intArrayOf(0,1,1,0,0),
//        intArrayOf(1,1,0,0,0),
    )
    val hits = arrayOf(
//        intArrayOf(1,1)



        intArrayOf(6,0),
        intArrayOf(1,0),
        intArrayOf(4,3),
        intArrayOf(1,2),
        intArrayOf(7,1),
        intArrayOf(6,3),
        intArrayOf(5,2),
        intArrayOf(5,1),
        intArrayOf(2,4),
        intArrayOf(4,4),
        intArrayOf(7,3)
    )
    val array = solution.hitBricks(matrix, hits)
    for(i in array)
        println(i)
}