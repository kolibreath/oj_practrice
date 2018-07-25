import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor;

import java.util.ArrayList;
import java.util.List;

public class SprialOrder {



        static class SolutionSprialOrder {
            public List<Integer> spiralOrder(int[][] matrix) {

                if(matrix == null || matrix.length == 0 ||matrix[0].length == 0){
                    return new ArrayList<>();
                }
                int fromH,fromV,endH,endV;
                int singleLength = matrix[0].length;
                int matrixWidth = matrix.length;
                List<Integer> list = new ArrayList<>();
                for(int i = 0; i<=matrix[0].length/2 && i <= matrix.length /2  ;i ++){
                    fromH = i;
                    endH = singleLength - i - 1;
                    fromV = i;
                    endV = matrixWidth - i -1 ;
                    int m [][] = getMatrix(matrix,fromH,endH,fromV,endV);
                    printCircle(m,list);

                    if(m.length <= 2|| m[0].length <= 2 )
                        break;
                }
                return list;
            }

            int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
            public int[][] getMatrix(int[][] matrix, int fromH,int endH,int fromV, int endV){

                int [][] m = new int[(endV - fromV) == 0 ? 1 : endV - fromV + 1 ][(endH - fromH) == 0 ? 1: endH - fromH + 1 ];

                for (int j= 0;j<m.length;j++){
                    for(int i=0;i<m[0].length;i++){
                        m[j][i] = matrix[fromV+j][i+fromH];
                    }
                }
                return m;
            }

            public void printCircle(int [][] matrix,List<Integer> list1){
                int singleLength = matrix[0].length;
                int matrixWidth = matrix.length;

                List<Integer> list = new ArrayList<>();

                for(int i=0;i<singleLength;i++){
                    log(list,matrix[0][i]);
                }
                for(int i=1;i<matrixWidth;i++){
                    log(list,matrix[i][singleLength - 1]);
                }

                if(list.size() == matrixWidth || list.size() == singleLength) {
                    for(int i: list){
                        list1.add(i);
                    }
                    return;
                }

                for(int i = singleLength -2;i>=0;i--) {
                    log(list,matrix[matrixWidth - 1][i]);
                }

                for(int i = matrixWidth - 2;i>=1;i--){
                    log(list,matrix[i][0]);
                }

                for (int i:list){
                    list1.add(i);
                }


            }

            public void log(List<Integer> i,int value){
                i.add(value);
            }
        }
}
