public class 甲板上的战舰 {
    static class Solution {
        public int countBattleships(char[][] board) {
            int m = board.length;
            int n = board[0].length;
            vis = new boolean[m][n];
            dfs(board, m, n);
            return count;
        }

        private int count = 0;
        private boolean[][] vis;
        private void dfs(char[][] board, int m, int n) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (vis[i][j]) continue;
                    vis[i][j] = true;
                    if (board[i][j] == 'X') {
                        // 查看右边
                        int c = j + 1;
                        while(check(i, c, m, n) && board[i][c] == 'X') {
                            vis[i][c] = true;
                            c++;
                        }
                        // 查看下面
                        int k = i + 1;
                        while(check(k, j, m, n) && board[k][j] == 'X') {
                            vis[k][j] = true;
                            k ++;
                        }
                        count ++;
                    }
                }
            }
        }

        private boolean check(int i, int j, int m, int n) {
            if (i >= m || j >= n || i < 0 || j < 0) return false;
            else return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][] {
                {'X','X','X','.','.'},
                {'.','.','.','X','.'},
                {'.','X','.','X','.'},
                {'.','X','.','X','.'},
                {'.','X','.','.','.'},
        };
        System.out.println(solution.countBattleships(board));
    }
}
