# SingleNumber
[原题](https://leetcode.com/problems/single-number/description/)

这个题简单来说的可以使用HashTable完成，如果使用数组完成的话，数组中不能有负数作为下标，很容易gg

一个数和0异或是本身，两个相同的数字异或是0，将这个数列所有的数字异或就是最终的结果
````
public class SingleNumber {
        public static class Solution {
            public int singleNumber(int[] nums) {
                int res = 0;
                for (int num : nums)
                    res ^= num;
                return res;
            }
        }

}

````
