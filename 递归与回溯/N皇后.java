import java.util.ArrayList;
import java.util.List;

public class N皇后 {
    static class Solution {
        private ArrayList<List<String>> list = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            int[] record = new int[n];
            for(int i = 0; i < n; i ++) record[i] = -1;
            dfs(n, 0, record);
            return list;
        }

        private void dfs(int n, int i, int[]record) {
            if (i == n) {
                // 将record中的内容进行整理
                handle(record);
                return;
            }

            for(int j = 0; j < n;j ++) {
                if (isValid(i, j, record)) {
                    record[i] = j;
                    dfs(n, i + 1, record);
                }
            }
        }

        private void handle(int[] record) {
            ArrayList<String> con = new ArrayList<>();
            for(int i = 0; i < record.length; i ++ ){
                if(record[i] == -1) return;
                StringBuilder builder = new StringBuilder();
                int j = record[i];
                // .
                for (int k = 0; k < j; k ++) builder.append(".");
                // Q
                builder.append("Q");
                // .
                for (int k = j + 1; k < record.length; k++) builder.append(".");
                con.add(builder.toString());
            }
            list.add(con);
        }

        // 当前的i j所表示的皇后和record中的皇后是否存在重复交集
        private boolean isValid(int i, int j, int[] record) {
            for(int k = 0; k <= i - 1; k ++) {
                // record: k, record[k]
                if (record[k] == j || Math.abs(i - k) == Math.abs(j - record[k])) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        System.out.println(solution.solveNQueens(n));
    }
}
