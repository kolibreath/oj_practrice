# Graycode

https://leetcode.com/problems/gray-code/description/

这道题属于一道位运算类型的问题。
看到discuss 里面指出了一种生成格雷码地方法： 利用前面一个数字，当数字长度为0，list 中为0 ，当数字长度为1 ， list 中 0，1，
当数字长度为2 ，数字为 00 01 11 10 ，后面的数字是前面的数字加上pow(2,n-1) 

但是在加入数组地时候要颠倒过来。 因为这样恰好至该变了一个数字。

可以使用dp 做，但是dp做的话数据结构比较复杂，不如直接使用递归。

```
public class GrayCode {
    static class Solution {
        public List<Integer> grayCode(int n) {
            if(n == 0){
                List<Integer> list = new LinkedList<>();
                list.add(0);
                return list;
            }
            List <Integer> cur = grayCode(n-1);
            int add = (int) Math.pow(2,n-1);
            for(int i = cur.size() -1 ;i>=0;i--){
                cur.add(cur.get(i) + add);
            }
            return cur;
        }
    }
}

```

如果使用位运算的方法：

````
public List<Integer> grayCode(int n) {
    List<Integer> result = new LinkedList<>();
    for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
    return result;
}
````
