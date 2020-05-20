import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class 两个数组的交集 {
    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);Arrays.sort(nums2);
            int i = 0, j = 0;
            HashSet<Integer> set = new HashSet<>();
            while(i < nums1.length && j < nums2.length){
                if (nums1[i] < nums2[j]) i++;
                else if (nums1[i] > nums2[j]) j++;

                if(i >= nums1.length || j>= nums2.length) break;

                if(nums1[i] == nums2[j]){
                    set.add(nums1[i]);
                    i++;
                    j++;
                }
            }
            i = 0;
            int[] result = new int[set.size()];
            for (Integer integer:set) {
                result[i++] = integer;
            }
            return result;
        }
    }
}
