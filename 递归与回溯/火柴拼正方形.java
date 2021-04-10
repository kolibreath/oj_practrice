public class 火柴拼正方形 {
     class Solution {
        private int length ;
        private int sum = 0 ;
        private int sides[] = new int[4];
        public boolean makesquare(int[] nums) {
            if (nums == null || nums.length == 0) return false;
            for (int num : nums) sum += num;
            length  = sum / 4;
            if (length * 4  != sum) return false;
            return dfs(nums,0);
        }

        private boolean dfs( int nums[], int index){
            if (sides[0] == length && sides[0] == sides[1] &&sides[1] == sides[2] && sides[2] == sides[3]) return true;
            if (index >= nums.length) return false;
            for(int i = 0; i < 4; i++ ){
                //尝试将当前的火柴加入目前选中的边
                if(sides[i] + nums[index] <= length){
                    sides[i] +=  + nums[index];
                    if(dfs(nums,index+1)) return true;
                    sides[i] -=  + nums[index];
                }
            }
            return false;
        }
    }
}