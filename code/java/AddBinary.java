import java.util.Arrays;

public class AddBinary{
    static class Solution {
        public String addBinary(String a, String b) {

            int forward = 0;
            int max = a.length() > b.length() ? a.length() : b.length();
            char sa[] = new char[max + 1];
            for(int i = a.length() - 1, j = b.length() -1 ;i >= 0 || j >= 0 ; i -- ,j --){
                int c, d;
                if(i < 0){
                    c = 0;
                }else{
                    c = a.charAt(i) - '0';
                }
                if(j < 0) {
                    d = 0;
                }else{
                    d = b.charAt(j) - '0';
                }
                sa[max--] = (char)( (c + d + forward )%2 + '0');
                forward = (c + d + forward) /2;
            }
            sa[max] = (char) (forward + '0');
            boolean flag = false;
            String result = "";
            for(char c: sa){
                if(c - '0' != 0)
                    flag  = true;
                if(flag)
                    result += c;
            }
            return result.length() == 0 ? "0" : result;
        }
    }
}
