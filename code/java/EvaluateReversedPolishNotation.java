import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EvaluateReversedPolishNotation {

   static  class Solution {
        public int evalRPN(String[] tokens) {
            //考虑特殊情况
            if(tokens.length == 1)
                return Integer.parseInt(tokens[0]);
            LinkedList<String> list = new LinkedList<>();
            List<String> ops = new ArrayList<>();
            ops.add("*");
            ops.add("+");
            ops.add("-");
            ops.add("/");
                int sum = 0;
            for(String token:tokens){
                list.push(token);
                if(ops.contains(token)){
                    String op = list.pop();
                    int right = Integer.parseInt(list.pop());
                    int left = Integer.parseInt(list.pop());

                    if(op.equals("+")){
                        sum = left + right;
                    }else if(op.equals("-")){
                        sum = left - right;
                    }else if(op.equals("*")){
                        sum = left * right;
                    }else{
                        sum = left / right;
                    }

                    list.push(String.valueOf(sum));
                }
            }

            return sum;
        }
    }
}
