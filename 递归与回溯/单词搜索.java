public class 单词搜索 {
    static class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length, n = board[0].length;
            char[] chars = word.toCharArray();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (chars[0] == board[i][j]) {
                        if (chars.length == 1) return true;
                        if (dfs(board, chars, new int[m][n], i, j , 1))
                            return true;
                    }
                }
            }
            return false;
        }

        private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        private boolean dfs(char[][]board, char[] chars, int[][] vis, int i, int j, int index) {
            if (index == chars.length) return true;
            vis[i][j] = 1;
            for (int[] dir : dirs) {
                int nexti = dir[0] + i, nextj = dir[1] + j;
                if (check(nexti, nextj, board.length, board[0].length) &&
                        board[nexti][nextj] == chars[index] && vis[nexti][nextj] != 1)
                    if (dfs(board, chars, vis, nexti, nextj, index + 1))
                        return true;
            }
            vis[i][j] = 0;
            return false;
        }

        private boolean check(int i, int j, int m, int n) {
            return i >= 0 && i < m && j >= 0 && j < n;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}};
        String a = "ABCESEEEFS";
        System.out.println(solution.exist(board, a));
    }
}
