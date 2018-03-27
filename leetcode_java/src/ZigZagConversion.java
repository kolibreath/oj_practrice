import java.util.Arrays;

/**
 * Created by kolibreath on 18-3-25.
 */
public class ZigZagConversion {

    static public class Solution {
        public String convert(String s, int nRows) {
            int length = s.length();
            if(nRows==1||length ==0)
                return s;
            int row = 0, delta = 1;
            String arrays[] = new String[nRows];
            Arrays.fill(arrays,"");
            for(int i=0;i<s.length();i++){
                arrays[row]  += s.charAt(i);
                row  = row + delta;
                if(row==nRows){
                    delta = -1;
                    row = nRows-2;
                }
                if(row==-1){
                    delta = 1;
                    row = 1;
                }
            }
            String result = "";
            for(int i=0;i<arrays.length;i++){
                result += arrays[i];
            }
            return result;
        }
    }
}
