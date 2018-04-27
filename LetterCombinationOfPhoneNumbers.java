import java.util.LinkedList;
import java.util.List;

public class Leetcode17 {


    static class Solution {
        public List<String> letterCombinations(String digits) {
            LinkedList<String> ans = new LinkedList<String>();
            String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            if (digits.contains("1")||digits.contains("0")||"".equals(digits))return ans;
            ans.add("");
            for(int i =0; i<digits.length();i++){
                int x = Character.getNumericValue(digits.charAt(i));
                while(ans.peek().length()==i){
                    String t = ans.remove();
                    for(char s : mapping[x].toCharArray())
                        ans.add(t+s);
                }
            }
            return ans;
        }
    }

}
