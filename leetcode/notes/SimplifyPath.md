# Simplify Path

[原题](https://leetcode.com/problems/simplify-path/description/)
开始想使用Java正则表达式加上栈完成 但是不行 
正则表达式是贪心的 很难做一个很好的构造

这个题可以用栈轻松拿下，但是需要考虑一些特殊情况 ，比较优化的答案是这个：
```
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for(String s: path.split("/")){
            if(!stack.isEmpty() && s.equals("..")) stack.pop();
            else if(!s.equals("..") && !s.equals("") && !s.equals(".")) stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()) return "/";
        for(Iterator<String> it = stack.descendingIterator();it.hasNext();)sb.append("/").append(it.next());
        return sb.toString();
    }
}
```

可以使用descendingIterator()反向遍历
