public class 可能的二分法{
    class Solution {
        Map<Integer, Integer> color ;
        ArrayList<Integer> []matrix ; 
        public boolean possibleBipartition(int N, int[][] dislikes) {
            //构建邻接表
            matrix = new ArrayList[N+1];
            for (int i = 1; i <= N ;i++) matrix[i] = new ArrayList();

            for (int dislike[]: dislikes){
                matrix[dislike[0]].add(dislike[1]);
                matrix[dislike[1]].add(dislike[0]);
            }
            color = new HashMap();   
            for (int i = 1; i <= N ;i++){]
                if (!color.containsKey(i))
                    if(!dfs(i, 0)) 
                        return false;
            }         
            return true;
        }

        public boolean dfs(int index, int c){
            if (color.containsKey(index)) return color.get(index) == c;
            color.put(index, c);

            for (int nei: matrix[index]){
                if(!dfs(nei, c ^ 1)) return false;
            }
            return true;
        }
    }
}