public class AddStrings {
    static class Solution {
        public String addStrings(String num1, String num2) {
            int p1 = num1.length(), p2 = num2.length();
            int max = p1 >= p2 ? p1 :p2;
            int result [] = new int[max + 1];
            int forward = 0;
            for(int i = num1.length() -1 ,j = num2.length() -1 ; i>=0 || j>=0|| forward ==1;i--,j-- ){
                int a = i<0 ? 0 : num1.charAt(i) - '0';
                int b = j<0 ? 0 : num2.charAt(j) - '0';

                result[max--] = (a + b + forward) %10;
                forward = (a + b + forward)/10;
            }

            String str = "";
            boolean flag = true;
            for(int i : result){
                if(i == 0 && flag){
                    continue;
                }else{
                    flag = false;
                    str += i;

                }
            }

            return str.length() == 0? "0" : str;
        }
    }
}
