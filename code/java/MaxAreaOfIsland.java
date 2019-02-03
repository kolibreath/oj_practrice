public class MaxAreaOfIsland {
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {

            int maxArea = 0;
            for(int i=0;i<grid.length;i++){
                for(int j =0;j<grid[0].length;j++){
                    maxArea = Math.max(getMax(grid,i,j),maxArea);
                }
            }
            return maxArea;
        }

        public int getMax(int [][]grid,int i,int j){
            if( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
                return 0;

            int max = 1;
            grid[i][j] = 0;
            max = max + getMax(grid,i+1,j) + getMax(grid,i-1,j) + getMax(grid,i,j+1) +getMax(grid,i,j-1);
            return max;
        }
    }
}
