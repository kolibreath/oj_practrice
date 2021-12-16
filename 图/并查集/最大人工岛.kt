class 最大人工岛 {
    class Solution {
        fun largestIsland(grid: Array<IntArray>): Int {
            val n = grid.size
            fun getIndex(i: Int, j: Int): Int = i * n + j
            // 计算没有开始尝试时的并查集情况
            val unionFind = UnionFind(n*n)
            val zeros = ArrayList<Pair<Int, Int>>()

            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (grid[i][j] == 1) {
                        if (i > 0 && grid[i - 1][j] == 1) {
                            // 上面存在一个1
                            unionFind.union(getIndex(i, j), getIndex(i - 1, j))
                        }
                        if (j > 0 && grid[i][j - 1] == 1) {
                            // 左边存在一个1
                            unionFind.union(getIndex(i, j), getIndex(i, j - 1))
                        }
                    } else zeros.add(Pair(i, j))
                }
            }
            // 全部都为1
            if (zeros.size == 0) return n * n
            else if (zeros.size == n * n) return 1

            val directions = arrayOf(
                intArrayOf(1, 0),
                intArrayOf(-1, 0),
                intArrayOf(0, 1),
                intArrayOf(0, -1)
            )

            fun isValid(nextx: Int, nexty: Int): Boolean = !(nextx < 0 || nextx >= n || nexty < 0 || nexty >= n)

            // 遍历每一个0 记录当前的最大值
            var max = unionFind.maxSize()
            for(pair in zeros) {
                val i = pair.first; val j = pair.second
                // 因为并查集需要归并 但是也需要保存现场
                if (grid[i][j] == 0) {
                    // 检查i j 周边四个方向然后归并
                    val parentscp = IntArray(n * n) { unionFind.parents[it] }
                    val sizeMapcp = IntArray(n * n) { unionFind.sizeMap[it] }
                    for (dir in directions) {
                        val nextx = i + dir[0]
                        val nexty = j + dir[1]
                        if (isValid(nextx, nexty) && grid[nextx][nexty] == 1) {
                            unionFind.union(getIndex(i, j), getIndex(nextx, nexty))
                        }
                    }
                    val m = unionFind.maxSize()
                    if (m > max) max = m
                    unionFind.parents = parentscp
                    unionFind.sizeMap = sizeMapcp
                }
            }
            return max
        }

        class UnionFind(size: Int) {
            var parents = IntArray(size) {it}
            var sizeMap = IntArray(size) {1}

            fun find(x: Int): Int {
                if (parents[x] == x) {
                    return x
                }
                val p = find(parents[x])
                parents[x] = p
                return p
            }

            fun union(x: Int, y: Int) {
                val headx = find(x)
                val heady = find(y)
                if (headx == heady) return
                parents[heady] = headx
                sizeMap[headx] += sizeMap[heady]
            }

            // 寻找sizemap的最大值
            fun maxSize(): Int = sizeMap.max()!!

            private fun getSize(x: Int): Int {
                val head = find(x)
                return sizeMap[head]
            }
        }

    }
}

fun main() {
    val solution = 最大人工岛.Solution()
    val grid = arrayOf(
//        intArrayOf(1,0,1,0),
//        intArrayOf(0,1,1,1),
//        intArrayOf(0,0,0,0),
//        intArrayOf(0,1,0,0),
    intArrayOf(0,0),
    intArrayOf(0,0)
    )
    println(solution.largestIsland(grid))
}