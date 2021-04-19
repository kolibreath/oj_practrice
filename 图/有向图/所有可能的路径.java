public class 所有可能的路径 {
    class Solution {
        private List<List<Integer>> result = new LinkedList<>();
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<Integer> temp = new LinkedList<>(); temp.add(0);
            dfs(graph,temp,0);
            return result;
        }

        private void dfs(int[][]graph, List<Integer> cur, int node){
            if (node == graph.length - 1) {
                result.add(new LinkedList<>(cur)); return;
            }
            for (int i = 0; i < graph[node].length; i++){
                int nei = graph[node][i];
                cur.add(nei);
                dfs(graph,cur, nei);
                cur.remove(cur.size()-1);
            }
        }
    }
}