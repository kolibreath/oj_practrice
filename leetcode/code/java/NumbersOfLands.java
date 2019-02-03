public class NumbersOfLands {
    static class Solution {
        int[] dx = {-1,0,0,1};
        int[] dy = {0,1,-1,0};
        public int numIslands(char[][] grid) {
            int count = 0;
            for(int i = 0;i< grid.length;i++){
                for(int j = 0;j< grid[0].length ;j++){
                    if(grid[i][j] != '1') continue;
                    dfs(grid,i,j);
                    count++;
                }
            }
            return count;
        }

        void dfs(char[][] grid,int x ,int y){
            grid[x][y]  = 'x';
            for(int i= 0;i< dx.length;i++){
              if(x + dx[i] < grid.length && x + dx[i] >= 0 && y + dx[i] < grid[0].length && y + dx[i] >= 0
                      && grid[x + dx[i]][y + dy[i]] == '1'){
                  dfs(grid,x+dx[i],y+dy[i]);
              }
            }
        }
    }
}
