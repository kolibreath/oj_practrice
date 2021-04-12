public class 优美的排列 {
     class Solution {
        private int count = 0;
        public int countArrangement(int n) {
            int nums[] = new int[n];
            for (int i = 0 ; i<n ;i++) nums[i] = i+1;
            permute(nums, 0);
            return count;
        }

        private void permute(int nums[], int index){
            if (index == nums.length - 1) return;
            for (int i = index; i < nums.length  ; i++){
                swap(nums, index);
                //check
                if (nums[i] % (i+1) != 0 && (i+1) % nums[i] != 0) continue;
                permute(nums, index+1);
                swap(nums, index);
            }
        }

        private void swap(int nums[], int index){
            int temp = nums[index+1];
            nums[index+1] = nums[index];
            nums[index] = temp;
        }
    }
}