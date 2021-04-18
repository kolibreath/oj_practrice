public class 判断二分图 {
    class Solution {
        private HashMap<Integer, Integer> map = new HashMap<>();
        public boolean isBipartite(int[][] graph) {
            // 排除没有邻边的节点
            boolean valid = true;
            for (int i = 0; i < graph.length ; i++) {
                if (graph[i].length == 0) continue;
                if (!map.containsKey(i)) {
                    // 没有涂色
                    valid = dfs(graph, i, 0);
                    if (!valid) return false;
                }
            }
            return valid;
        }


        public boolean dfs(int[][] graph,int node,int color){
            if (map.containsKey(node)) return map.get(node) == color;
            map.put(node,color);
            for(int nei : graph[node]){
                //遍历当前节点的所有邻接结点
                if (!dfs(graph,nei,color ^ 1))
                    return false;
            }
            return true;
        }
    }
}