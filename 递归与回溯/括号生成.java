import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    static class Solution {
        public List<String> generateParenthesis(int n) {
            dfs(n, n, new StringBuilder());
            return ans;
        }

        private List<String> ans = new ArrayList<>();
        private void dfs(int left, int right, StringBuilder cur) {
            if (left == 0 && right == 0) {
                ans.add(cur.toString());
                return;
            }
            if (left > right) return;
            if(left - 1 >= 0) {
                StringBuilder b = new StringBuilder(cur);
                b.append("(");
                dfs(left - 1, right, b);
            }
            if(right- 1 >= 0) {
                StringBuilder b = new StringBuilder(cur);
                b.append(")");
                dfs(left, right - 1, b);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        List<String> result = solution.generateParenthesis(n);
    }
}
