public class DecodeStrings {
    static class Solution {
        public String decodeString(String s) {
           return decodeStrings(s,0);
        }

        String decodeStrings(String s, int i){
            String temp = "";
            while(i < s.length() && s.charAt(i) != ']'){
                if(Character.isAlphabetic(s.charAt(i))){
                    //直接在内部先处理好整个的cur
                    temp += s.charAt(i++);
                }else{
                    int count = 0;
                    //求出数字
                    while(i< s.length() &&
                            Character.isDigit(s.charAt(i))){
                        count = count*10 + s.charAt(i++) - 48;
                    }
                    i = i +1;
                    String cur = decodeStrings(s,i);
                    i = i + 2;
                    while(count -- > 0){
                        temp += cur;
                    }
                }
            }

            return temp;
        }
    }
}
