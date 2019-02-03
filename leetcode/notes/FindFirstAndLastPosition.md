
## 二分查找小于target数的最近的数字
[Find first and last position](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/)
通过数学方法，可以证明的有两点
- 二分查找中不可能出现的情况是low> high,如果出现low > high的话就会退出循环，可能出现的情况是low == high 和 low high，通过控制这个可以找到最靠近target数字的下界
- 经过有限次的运算(向下取整) low 会最终会和high相等

这道题需要注意 low 会逐渐的趋近于high， 但是一个判断不成立的条件是 low == A.length 所以 需要high 取得 a.length
另外 high = mid 而不是 high = mid - 1，因为当走else路线的时候可能的情况是target == numbers[mid]

````
 public class Solution {
       public int[] searchRange(int[] A, int target) {
           int start = Solution.firstGreaterEqual(A, target);
           if (start == A.length || A[start] != target) {
               return new int[]{-1, -1};
           }
           return new int[]{start, Solution.firstGreaterEqual(A, target + 1) - 1};
       }

       public  static int firstGreaterEqual(int numbers[], int target) {
           int low = 0, high = numbers.length;
           while (low < high) {
               int mid = low + ((high - low) >> 1);
               if (numbers[mid] < target) {
                   low = mid + 1;
               } else {
                   high = mid;
               }
           }
           return low;
       }
   }
````
