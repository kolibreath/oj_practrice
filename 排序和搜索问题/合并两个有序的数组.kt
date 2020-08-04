import java.util.*

class 合并两个有序的数组 {
    class Solution {
        fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
            System.arraycopy(nums2, 0, nums1, m, n);
            Arrays.sort(nums1)
        }

    }
}