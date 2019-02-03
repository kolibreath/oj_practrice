import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes{

    int nums[][] = new int[][]{
            {1,1,1},
            {1,0,1},
            {1,1,1}
    };

    static class Solution {

        public void setZeroes(int[][] matrix) {

            if(matrix.length ==0 || matrix[0].length ==0 || matrix ==null)
                return;

            int singleWidth = matrix[0].length;
            int matrixWidth = matrix.length;

            List<Integer> listH = new ArrayList<>();
            List<Integer> listV = new ArrayList<>();
            for(int i=0;i<matrixWidth;i++){
                for(int j=0;j<singleWidth;j++){
                    if(matrix[i][j] == 0){
                        if(!listH.contains(i)){
                            listH.add(i);
                        }
                        if(!listV.contains(j)){
                            listV.add(j);
                        }

                    }
                }
            }
            for(int x:listH){
                for(int y = 0;y<singleWidth;y++){
                    matrix[x][y] = 0;
                }
            }

            for(int y:listV){
                for(int x = 0;x<matrixWidth;x++){
                    matrix[x][y] = 0;
                }
            }

        }

    }
}
