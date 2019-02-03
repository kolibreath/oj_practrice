# 自己是先一个sqrtx

- 使用二分查找的方式实现：

从 1 到Integer.max_value
```
class Solution {
        public int mySqrt(int x) {
            if( x== 0)return 0;
            int left = 1, right = Integer.MAX_VALUE ;
            while(true){
                int mid = left + (right - left)/2;
                if(mid > x /mid){
                    right = mid -1;
                }else {
                    if (mid + 1 > x/(mid + 1))
                        return mid;
                    left = mid + 1;
                }
            }
        }
    }
```

类似这样的一个取整数的过程
使用牛顿法的原理和代码：

[原理](https://blog.csdn.net/shaw1994/article/details/43889479)
````
long r = x;
    while (r*r > x)
        r = (r + x/r) / 2;
    return (int) r;

````
