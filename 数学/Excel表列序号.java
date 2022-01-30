public class Excel表列序号 {
    class Solution {
        public int titleToNumber(String columnTitle) {
            int len = columnTitle.length();
            int sum = 0, time = 1;
            for (int i = len - 1; i >= 0; i--) {
                int cur = columnTitle.charAt(i) - 'A' + 1;
                sum += cur * time;
                time *= 26;
            }
            return sum;
        }
    }
}
