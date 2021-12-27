
import java.util.LinkedList;
import java.util.Stack;

public class 简化路径 {
    static class Solution {
        public String simplifyPath(String path) {
            LinkedList<String> stack = new LinkedList<>();
            char[] arr = path.toCharArray();
            for(int i= 0; i < arr.length;) {
                if (arr[i] == '/') {
                    // 进行后面的判断
                    // 字符序列
                    // . ..
                    i ++;
                    if (i >= arr.length) break;
                    // 取出两个/之间的部分
                    StringBuilder builder = new StringBuilder();
                    while(i < arr.length && arr[i] != '/') builder.append(arr[i++]);
                    String s = builder.toString();
                    if (s.length() == 0) continue;
                    if (s.charAt(0) != '.') stack.push(s);
                    else {
                        // s == '.' 忽略
                        if(s.equals("..")) {
                            if (!stack.isEmpty()) stack.pop();
                        } else if (s.equals(".")) { }
                        else {
                            stack.push(s);
                        }
                    }
                }
            }
            StringBuilder builder = new StringBuilder("/");
            for (int i = 0; i < stack.size(); i++) {
                builder.append(stack.get(i));
                if(i != stack.size() - 1) builder.append("/");
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String path = "/a//b////c/d//././/..";
        System.out.println(solution.simplifyPath(path));
    }
}
