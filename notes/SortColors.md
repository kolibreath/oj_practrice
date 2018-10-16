# SortColors

这道题解法有很多 让我写的时候感觉很奇怪，但是发现一个非常ok的解法：
```
 class Solution {
       void sortColors(int A[]) {
           int n0 = -1, n1 = -1, n2 = -1;
           for (int i = 0; i < A.length; ++i) {
               if (A[i] == 0)
               {
                   A[++n2] = 2; A[++n1] = 1; A[++n0] = 0;
               }
               else if (A[i] == 1)
               {
                   A[++n2] = 2; A[++n1] = 1;
               }
               else if (A[i] == 2)
               {
                   A[++n2] = 2;
               }
           }
       }
    }
```

如果直接使用 计数然后再放入的方法太low了 这种方法总结了一般的规律 0 1 2 是顺序排列的
