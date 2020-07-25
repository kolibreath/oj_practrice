import java.util.ArrayList;
import java.util.Collections;

public class 水域大小 {
    static class Solution {
        private int x[] = {-1,1, 0,0,-1,-1,1,1};
        private int y[] = {0, 0,-1,1,-1,1,-1,1};
        private int cur =0;

        private void dfs(int [][]land, int i, int j){
            int height = land.length;
            int width = land[0].length;

            if(i < 0 || i >= height || j < 0 || j >= width || land[i][j] != 0)
                return;
            land[i][j] = -1;
            cur ++;

            for (int k = 0; k < 8; k++)
                dfs(land, i + x[k], j + y[k]);
        }
        public int[] pondSizes(int[][] land) {
            int heigth = land.length;
            int width = land[0].length;

            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < heigth; i++) {
                for (int j = 0; j < width ; j++) {
                    if (land[i][j] != 0) continue;
                    dfs(land, i, j);
                    if (cur == 0) continue;
                    result.add(cur);
                    cur = 0;
                }
            }
            Collections.sort(result);
            int array[] = new int[result.size()];
            for (int i = 0; i < result.size(); i++) array[i] = result.get(i);
            return array;
        }
    }
}