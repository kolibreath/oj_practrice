import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class 找到最终的安全状态 {
    static class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int N = graph.length;
            int color[] = new int[N];
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < N ; i++) {
                if(dfs(i, color, graph)) result.add(i);
            }
            return result;
        }

        //white 0 (unvisited) gray 1 (visited) black 2 (safe)
        private boolean dfs(int start, int color[], int graph[][]){
            if(color[start] == 1) return false;
            if(color[start] == 2) return true;

            color[start] = 1;
            int neighbors[] = graph[start];
            for (int neighbor: neighbors) {
                boolean c = dfs(neighbor, color, graph);
                if(!c) return false;
            }
            color[start] = 2;
            return true;
        }
    }
}