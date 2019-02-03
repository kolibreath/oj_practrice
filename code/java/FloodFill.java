public class FloodFill   {

    static class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

            if (image[sr][sc] == newColor) return image;
            int oldColor = image[sr][sc];
            dfs(image,sr,sc,newColor,oldColor);

            return image;
        }

        public void dfs(int [][] image,int i,int j,int newColor,int oldColor){
            if(i<0||i>=image[0].length||j<0||j>=image.length)
                return;
            if(image[i][j]==oldColor)
                image[i][j] = newColor;
            else
                return;

            dfs(image,i+1,j,newColor,oldColor);
            dfs(image,i,j+1,newColor,oldColor);
            dfs(image,i,j-1,newColor,oldColor);
            dfs(image,i,j+1,newColor,oldColor);
        }
    }
}
