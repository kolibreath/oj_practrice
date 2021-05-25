public class 猜数字大小 {
    // 递归算法超时
    class Solution {
        public int getMoneyAmount(int n) {
            return dfs(1, n);
        }

        private int dfs(int low, int high){
            if (low >= high) return 0;
            int min = Integer.MAX_VALUE;
            for (int i = (low + high) / 2 ; i <= high; i++){
                int result = i + Math.max(dfs(low, i-1), dfs(i+1, high));
                min = Math.min(min, result);
            }
            return min;
        }
    }
}