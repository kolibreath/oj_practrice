public class 太平洋大西洋水流问题 {
    class Solution {
        private int [] dirx = {1,-1,0,0};
        private int [] diry = {0,0,1,-1};
        private boolean p[][];
        private boolean a[][];
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            p = new boolean[m][n];
            a = new boolean[m][n];
            for (int i = 0 ;i <m;i++)
                for (int j = 0; j<n;j++){
                    p[i][j] = false;
                    a[i][j] = false;
                }

            //从上边走
            for (int i = 0;  i < n; i++)
                dfs(p,heights,0,i);
            //从左边走
            for (int j = 0; j < m ;j++)
                dfs(p,heights,j,0);
            //从下边走
            for (int j = 0; j < n ;j++)
                dfs(a,heights,m-1,j);
            //从右边走
            for (int i = 0 ;i < m; i ++)
                dfs(a,heights, i, n-1);

            List<List<Integer>> result = new LinkedList<>();
            for (int i = 0; i < m ; i++){
                for (int j = 0 ; j < n ;j++){
                    if(a[i][j] && p[i][j]) {
                        List<Integer> list = new LinkedList<Integer>();
                        list.add(i);
                        list.add(j);
                        result.add(list);
                    }
                }
            }
            return result;
        }

        // 判断某一个点是否超出边界
        private boolean isIn(int [][]heights, int x, int y){
            int m = heights.length;
            int n = heights[0].length;

            return x < m && x >= 0 && y >= 0 && y < n;
        }

        private void dfs(boolean[][] visited, int[][] heights, int x , int y){
            visited[x][y] = true;
            for (int i = 0; i < 4; i++){
                int nextx = x + dirx[i];
                int nexty = y + diry[i];

                if (isIn(heights, nextx,nexty) && !visited[nextx][nexty] && heights[x][y] <= heights[nextx][nexty]){
                    dfs(visited,heights,nextx,nexty);
                }
            }
        }
    }
}