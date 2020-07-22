class Solution {
    fun gardenNoAdj(N: Int, paths: Array<IntArray>): IntArray {
        //将二维数组转换为邻接表
        val graph = Array<ArrayList<Int>>(N+1){ ArrayList()}

        //完成转换邻接表
        for(path in paths){
            graph[path[0]].add(path[1])
            graph[path[1]].add(path[0])
        }

        val result = IntArray(N)
        var count = 0
        while(++count <= N){
            val used = BooleanArray(N+1)
            val linked = graph[count]
            //根据邻接表中的元素使用过的颜色
            for (next in linked) used[result[next - 1]] = true
            //查看剩余的颜色
            for (index in 1..N)
                if (!used[index]) {
                    result[count - 1] = index
                    break
                }
        }
        return result
    }
}