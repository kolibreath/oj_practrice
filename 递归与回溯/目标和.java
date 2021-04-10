public class 目标和 {
   class Solution {
        // 表示不同的符号
        List<Integer> temp = new LinkedList<>();
        int all = 0;
        public int findTargetSumWays(int[] nums, int target) {
            int n = nums.length;
            for (int i = 0 ; i < (1 << n); i++){
                permute(i, n);
                int sum = 0;
                for (int j = 0 ; j < n ;j ++){
                    sum += temp.get(j) * nums[j];
                }
                if (target == sum) all ++;
            }
            return all;
        }

        private void permute(int mask, int n){
            temp.clear();
            for(int i = 0; i < n ; i ++){
                if (( mask & 1 ) != 0)
                    temp.add(-1);
                else
                    temp.add(1);
                mask >>= 1;
            }

        }
    }
}