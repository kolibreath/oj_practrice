import java.util.Collections;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class SimplifyPath {
    static class Solution {
        public String simplifyPath(String path) {

            if(path == null && path.length() == 0)
                return "";
            //some of the path may not ends with slash
            path = path +"/";
           return getPath(getStack(path));
        }

        public String getPath(LinkedList<String>stack){
            StringBuilder builder = new StringBuilder();
            if(stack.isEmpty())
                return "/";
            Collections.reverse(stack);
            while(!stack.isEmpty()){
                String cur = stack.poll();
                builder.append("/").append(cur);
            }
            return builder.toString();
        }
        public LinkedList<String> getStack(String input){
            LinkedList<String>  list= new LinkedList();
            StringBuilder builder = new StringBuilder();
            boolean leftSlash = false, rightSlash = false;
            for(int i= 0;i<input.length();i++){
                if(input.charAt(i) == '/' && !leftSlash){
                    leftSlash = true;
                    continue;
                }

                if(input.charAt(i) =='/'&& leftSlash){
                    rightSlash = true;
                }else {
                    builder.append(input.charAt(i));
                }

                if(leftSlash && rightSlash) {
                    String current = builder.toString();
                    if (current.equals("..")) {
                        if (!list.isEmpty()) {
                            list.pop();
                        }
                    }else if (current.equals(".")){
                        //do nothing!
                    } else {
                        if(!current.equals(""))
                            list.push(current);
                    }
                    builder = new StringBuilder();
                    rightSlash = false;
                }
            }

            return list;
        }
    }
}
