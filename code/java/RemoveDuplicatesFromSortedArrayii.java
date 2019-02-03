public class  RemoveDuplicatesFromSortedArrayii{

class Solution {
    public int removeDuplicates(int[] nums) {
        int counterIndex = 0;
        int counter = 0;
        int recent = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == recent) {
                if (counter < 2) {
                    counter++;
                    nums[counterIndex++] = nums[i];
                }
            } else {
                recent = nums[i];
                counter = 0;
                nums[counterIndex++] = nums[i];
                counter++;
            }
        }
        return counterIndex;
    }
}
}
