# Remove duplicates from sorted Array
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii

因为是一个sorted 的数组，所以后面的数字大于前面的：
非常巧妙
```
int i = 0;
for(int num:nums){
    //只有大于才会将数值放进去
    if(i < 2 || num > nums[i - 2]){
        nums[i] = num;
    }
}
```

