# Combination 
[原题](https://leetcode.com/problems/combinations/)

又是一个组合问题 这种题可以使用DFS 解决

如果是要求1 2 3 4 5 取出 4个数的组合 应该这样构建这棵树： 
递归+ 循环到整个临时储存的数组长度变成 4 然后退出一个 
1 2 3 
       ->4
       ->5
这样然后：
1 2 4 ->5 
。。。

如果使用Java编程的话 注意以下Arraylist 的remove 会remove一个object 但是直接传入 一个int 会被当成remove一个index
然后list<list<Integer>>中 如果每一个item放置的是一个引用的话，改变了储存的item的引用 会改变所有的值，最好每次新放入一个item（new 一个新的引用）

```
c class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<Integer> out = new LinkedList<>();
            List<List<Integer>> result = new LinkedList<>();

            helper(n,k,1,out,result);

            return result;
        }

        void helper(int n, int k, int level, List<Integer> out, List<List<Integer>> result){
            if(out.size() == k){
                List<Integer> cur = new LinkedList<>(out);
                result.add(cur);
                return;
            }
            for(int i = level;i<=n;i++){
                out.add(i);
                helper(n,k,i+1,out,result);
                Integer o = i;
                out.remove(o);
            }
        }
    }
```
