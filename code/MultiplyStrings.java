public class MultiplyStrings {
   static  class Solution {
        public String multiply(String num1, String num2) {
            if(num1==null || num2 == null)
                return "";
            int p1 = num1.length(), p2 = num2.length();
            int result[] = new int[p1 + p2];
            for(int i = p1 - 1;i>=0;i--){
                for(int j = p2 - 1;j>=0;j--){
                    int multi = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
                    int curP = i + j + 1;
                    int curPB = i + j;
                    int sum = result[curP] + multi;

                    result[curP] = sum % 10;
                    result[curPB] = result[curPB] + sum/10;
                }
            }

            String anwser = "";
            boolean flag = true;
            for(int i : result){
                if(i == 0 && flag)
                    continue;
                else{
                    flag = false;
                    anwser += i;
                }
            }
            return anwser.length() == 0? "0":anwser;
        }
    }
}
