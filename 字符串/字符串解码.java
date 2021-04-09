public class 字符串解码{
   class Solution {
        int index = 0;
        public String decodeString(String s) {
            StringBuilder builder = new StringBuilder();
            LinkedList<String> stack = new LinkedList<>();
            while(index < s.length()) {
                char c = s.charAt(index);
                if(Character.isDigit(c)){
                     String num = getDigits(s);
                    stack.add(num);
                }else if(Character.isAlphabetic(c) || s.charAt(index) == '['){
                    stack.add(String.valueOf(s.charAt(index++)));
                }else {
                    index ++;
                    LinkedList<String> con = new LinkedList<>();
                    while(!"[".equals(stack.peekLast()))
                        con.add(stack.removeLast());
                    Collections.reverse(con);
                    stack.removeLast();

                    StringBuilder bld = new StringBuilder();
                    String o = getString(con);
                    int num = Integer.parseInt(stack.removeLast());
                    while(num -- > 0)
                        bld.append(o);
                    stack.add(bld.toString());
                }
            }
            return getString(stack);
        }
        public String getString(LinkedList<String> list){
            StringBuilder builder = new StringBuilder();
            for (String i : list) builder.append(i);
            return builder.toString();
        }
        public String getDigits(String str){
            StringBuilder ret = new StringBuilder();
            while(Character.isDigit(str.charAt(index)))
                ret.append(str.charAt(index++));
            return ret.toString();
        }

    }
}