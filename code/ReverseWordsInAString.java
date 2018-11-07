import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReverseWordsInAString {
    static public class Solution {
        public String reverseWords(String s) {
            if(s == null || s.length() ==0)
                return "";

            boolean flag=  false;
            for(int i =0;i<s.length();i++) {
                if (s.charAt(i) == ' ')
                    continue;
                else {
                    flag = true;
                    break;
                }
            }

            if(!flag){
                return "";
            }

            int start = 0, end = 0;
            int wordLength = 0;

            s = s.trim();
            String result = "";
            int length = s.length();

            for(int i = 0;i<length;i++){
                if(s.charAt(i)==' '||i == length -1) {
                    end = i == length-1 ? length  : i;
                    start = i == length -1 ? end - 1 - wordLength   :end - wordLength;
                    result = result.length() == 0 ? s.substring(start,end) :   s.substring(start,end) + " " + result;
                    wordLength = 0;
                    continue;
                }
                wordLength ++;
            }

            return result;
        }
    }
}
