import java.util.ArrayList;

public class 验证二叉树 {
    static class Solution {
        public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
            ArrayList<Integer>[] graph = new ArrayList[n];
            int indegree[] = new int[n];
            int outdegree[] = new int[n];

            for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
            for (int i = 0; i < n ; i++) {
                if(leftChild[i] != -1) {
                    outdegree[i]++;
                    indegree[leftChild[i]] ++;
                    graph[i].add(leftChild[i]);
                }
                if(rightChild[i]!= -1) {
                    outdegree[i]++;
                    indegree[rightChild[i]]++;
                    graph[i].add(rightChild[i]);
                }
            }
            //找到入度为0的节点作为根节点 如果存在入度不为0的节点就返回false
            int start = 0;
            for (int i = 0; i < n ; i++) {
                if(indegree[i] == 0) {
                    start = i;
                }
                if(indegree[i] > 1) return false;
            }
            int visited[] = new int[n];
            boolean dfs = dfs(start,graph,visited);
            return dfs && count == n;
        }
        private int count = 0;
        private boolean dfs(int start,ArrayList<Integer>[] graph, int []visited){
            if(visited[start] == -1) return false;
            count++;
            visited[start] = -1;
            ArrayList<Integer> neighbors = graph[start];
            boolean flag = true;
            for (int neighbor: neighbors) {
                boolean f = dfs(neighbor,graph,visited);
                flag = f && flag;
            }
            return flag;
        }
    }
}