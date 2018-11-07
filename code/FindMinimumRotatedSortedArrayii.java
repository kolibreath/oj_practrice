import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMinimumRotatedSortedArrayii {
    class Solution {
        public int findMin(int[] nums) {
            if(nums.length ==0 || nums== null)
                return 0;
            if(nums.length == 1){
                return nums[0];
            }

            List<Integer> list = new ArrayList<>();
            for (int num : nums) list.add(num);

            Collections.sort(list);
            return list.get(0);
        }
    }
}
