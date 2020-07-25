public class 统计封闭岛屿的个数 {
    static class Solution {
        //上下左右
        private int dirx[] = {-1,1,0,0};
        private int diry[] = {0,0,-1,1};

        private int count =0;
        private void dfs(int [][]grid, int x, int y){
            int height = grid.length;
            int width = grid[0].length;
            if(x < 0 || x >= height || y < 0 || y >= width) return;
            if(grid[x][y] !=0) return;

            grid[x][y] = -1;
            for (int i = 0; i < 4 ; i++)
                dfs(grid, x + dirx[i] , y + diry[i]);
        }
        public int closedIsland(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;

            //边界上的陆地全都不能作为封闭陆地 直接标记掉
            for (int i = 0; i < width; i++) {
                dfs(grid,0,i);
                dfs(grid, height-1,i);
            }

            for (int i = 0; i < height ; i++) {
                dfs(grid, i,0);
                dfs(grid, i, width-1);
            }

            //真实的封闭陆地
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width ; j++) {
                    if (grid[i][j] != 0) continue;
                    dfs(grid, i, j);
                    count++;
                }
            }
            return count;
        }
    }
}