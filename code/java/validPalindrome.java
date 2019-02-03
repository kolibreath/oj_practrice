public class validPalindrome {

    static class Solution {
        public boolean isPalindrome(String s) {
            if(s == null)
                return false;
            if(s.equals(""))
                return true;
            int i = 0, j = s.length() -1;
            while(i <= j){
                char left = s.charAt(i);
                char right = s.charAt(j);

                if(!Character.isDigit(left) && !Character.isAlphabetic(left)){
                    i ++;
                    continue;
                }

                if(!Character.isDigit(right) && !Character.isAlphabetic(right)){
                    j --;
                    continue;
                }

                String leftS = left +"";
                String rightS = right + "";

                if(leftS.equalsIgnoreCase(rightS)){
                    i++;
                    j--;
                }else{
                    return false;
                }
            }

            return true;
        }
    }
}
