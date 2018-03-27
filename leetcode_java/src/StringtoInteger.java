/**
 * Created by kolibreath on 18-3-27.
 */
public class StringtoInteger {
    public static class Solution {
        public int myAtoi(String str) {
            if(str.length()==0||str==null){
                return 0;
            }
            str = str.trim();
            int i = 0, postivie = 1;
            if (str.charAt(0) == '+') {
                i++;
                postivie = 1;
            }
            if(str.charAt(0)=='-'){
                i++;
                postivie = -1;
            }

            double temp  = 0;
            for(;i<str.length();i++){
                int digit = str.charAt(i) - '0';
                if(digit<0||digit>9)
                    break;

                if(postivie==1){
                    temp = temp*10 + digit;
                    if(temp>Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                }
                if(postivie==-1){
                    temp = temp*10 - digit;
                    if(temp<Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                }
            }
            return (int)temp;
        }
    }


}
