# Validate BST

[source problem](https://leetcode.com/problems/validate-binary-search-tree/description/)

不代表一个子树是一个BST 就可以，比如会有这样的情况：
![](https://wx4.sinaimg.cn/mw690/d6225d36gy1fwdsu1n9epj20u01hc1bw.jpg)

所以直接递归判断子树的情况是不行的。
