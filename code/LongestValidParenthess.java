import java.util.Stack;

public class LongestValidParenthess {

    static class Solution {
        public int longestValidParentheses(String s) {

            Stack<Integer> stack = new Stack<>();
            int start = 0;
            int max = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='(')
                    stack.push(i);
                else {
                    if(stack.isEmpty()){
                        start = i + 1;
                    }else{
                        stack.pop();
                        max = stack.isEmpty()?Math.max(max,i-start +1):Math.max(max,i - stack.peek());
                    }
                }
            }
            return max;
        }
    }
}
