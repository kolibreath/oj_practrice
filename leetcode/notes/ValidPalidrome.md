# Valid Palidrome

这道题和一般的判定回文的方法不太相同，一段话如果去除标点符号和空格并且忽略大小写的话也可以称作是回文

一般思路采取先去除特殊操作的方法，然后正常判断 ，使用双指针就可以解决

但是我看到一个非常骚气的正则表达式方法
```
public class Solution {
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}
```

使用""取代 
但是这样效率不会太高
