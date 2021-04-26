public class 矩阵中的路径 {
    class Solution {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        public boolean exist(char[][] board, String word) {
             int m = board.length;
            int n = board[0].length;
            
            for(int i = 0 ; i< m; i++){
                for(int j = 0; j < n; j ++){
                    boolean visited[][] = new boolean[m][n];
                    Arrays.fill(visited,false);
                    if (board[i][j] == word.charAt(0)) {
                        if(dfs(board,i,j,word,0)) return true;
                    }
                }
            }
            return false;
        }
        private boolean dfs(char[][]board,int x,int y,String word,int index){
            for(int i = 0 ; i < 4 ; i++){
                int nextx = x + dx[i];
                int nexty = y + dy[i];
                if(!isIn(board,nextx,nexty) || word.charAt(index) != board[x][y]) continue;
                boolean result =  dfs(board,nextx,nexty,word,index + 1);
                if (result) return true;
            }
            return false;
        }

        private boolean isIn(char[][]board,int x,int y){
            int m = board.length;
            int n = board[0].length;
            if (x >=m || y >= n || x < 0 || y < 0) return false;
            return true;
        }
    }
}