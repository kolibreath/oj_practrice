public class CountAndSay {
    static class Solution {
        public String countAndSay(int n) {
            String start = "1";
            while(--n > 0){
                int count = 0;
                char cur =' ';
                String loop = "";
                for(int i=0;i<start.length();i++){
                    if(i == 0){
                        cur = start.charAt(i);
                    }
                    if(cur == start.charAt(i))
                        count++;
                    else{
                        loop += String.valueOf(count) + String.valueOf(cur);
                        cur = start.charAt(i);
                        count = 1;
                    }
                }
                loop += String.valueOf(count) + String.valueOf(cur) ;
                start = loop;
            }
            return start;
        }
    }
}
