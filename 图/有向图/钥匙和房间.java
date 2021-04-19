public class 钥匙和房间 {
   class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int[]visited = new int[rooms.size()];
            Arrays.fill(visited,0);
            dfs(rooms, visited, 0);
            for (int j : visited) if (j == 0) return false;
            return true;
        }

        private void dfs(List<List<Integer>> rooms, int[] visited, int index){
            visited[index] = 1;
            List<Integer> next = rooms.get(index);
            for(int i : next){
                if (visited[i] == 1) continue;
                dfs(rooms,visited,i);
            }
        }
    }
}