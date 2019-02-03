import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class RestoreIPAddress {
   static  class Solution {
       boolean flag = false;
        public void restore(String s, int start,int k,List<String> possible,List<String> result){
            if(k == 4){
                String resultString = "";
                for(String each : possible){
                    resultString += each +".";
                }
                //总结一些substring 规律！！
                resultString = resultString.substring(0,resultString.length()-1);
                result.add(resultString);

                flag = true;

                return;
            }

            for(int i=1;i<=3;i++) {
                String subString;
                if(possible.size() == 3){
                    subString = s.substring(start,s.length());
                    if(!isValid(subString)){
                        break;
                    }
                }else {
                    int end = start + i > s.length() ? s.length() : start + i;
                    String temp = s.substring(start,end);
                    subString = s.substring(start, end);
                }
                if (isValid(subString)) {
                    possible.add(subString);
                    restore(s, start + i,k + 1, possible,result);

                    if(flag) break;
                }
            }
            flag = false;
            possible.remove(possible.size()-1);
        }

       public List<String> restoreIpAddresses(String s) {

           List<String> possible = new LinkedList<>();
           List<String> result   = new LinkedList<>();
           restore(s,0,0,possible,result);

           return result;
       }


        public boolean isValid(String s){
            if(s.length() == 0)
                return false;
            int temp = Integer.parseInt(s);
            return temp < 256 && temp > 0;
        }
    }

}
