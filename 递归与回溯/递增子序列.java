public class 递增子序列 {
     class Solution {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            dfs(0, nums);
            return result;
        }

        private boolean isValid(){
            if(temp.size() < 2) return false;
            for(int i = 1 ;i < temp.size(); i++){
                if(temp.get(i) < temp.get(i-1)) return false;
            }
            return true;
        }
        // 使用串哈希算法
        private int hash(){
            int hashValue = 0;
            for(int x : temp){
                hashValue = hashValue * 263 % 1000000007 + (x + 101);
                hashValue %= 1000000007;
            }
            return hashValue;
        }

        private boolean isDuplicated(int hash){
            if (!set.contains(hash)) {
                set.add(hash);
                return false;
            }else{
                return true;
            }
        }

        // 使用递归的思路枚举元素
        private void dfs(int index, int[]nums){
            if (index == nums.length){
                int hashValue = hash();
                if (isValid() && !isDuplicated(hashValue)) result.add(new ArrayList<>(temp));
                return ;
            }
            // 考虑当前的元素
            temp.add(nums[index]);
            dfs(index+1, nums);
            temp.remove(temp.size() - 1);
            // 如果不考虑当前的元素进行递归
            dfs(index+1, nums);
        }
    }
}