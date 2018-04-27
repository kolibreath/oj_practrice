import java.util.HashMap;
import java.util.Stack;

public class ValidParenthes {
    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                    stack.push(s.charAt(i));
                }else{
                    if(stack.empty()) return false;
                    if(stack.peek()=='{'&&s.charAt(i)!='}') return false;
                    if(stack.peek()=='['&&s.charAt(i)!=']') return false;
                    if(stack.peek()=='('&&s.charAt(i)!=')') return false;

                    stack.pop();
                }
            }
            return true;
        }
    }
}
