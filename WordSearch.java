public class WordSearch {

    static class Solution {
        public boolean exist(char[][] board, String word) {

            if(board == null || board.length ==0 || board[0].length ==0 )
                return false;

            int singleWidth = board[0].length;
            int boardWidth  = board.length;
            boolean visited[][] = new boolean[boardWidth][singleWidth];

            for(int i = 0;i<boardWidth;i++){
                for(int j= 0; j <singleWidth;j++){
                    if(dfs(0,board,word,i,j,visited)){
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean dfs(int index, char [][] board,
                           String word, int rowindex,
                           int colindex, boolean visited[][]){
            if(index == word.length()){
                return true;
            }

            if(rowindex < 0 || colindex < 0 || rowindex >= board.length || colindex >= board[0].length){
                return false;
            }

            if(visited[rowindex][colindex]){
                return false;
            }

            if(word.charAt(index) != board[rowindex][colindex]){
                return false;
            }

            visited[rowindex][colindex] = true;

            boolean res = (dfs(index + 1, board, word, rowindex + 1, colindex,visited)||
                    dfs(index + 1, board, word, rowindex, colindex+1,visited)||
                    dfs(index + 1, board, word, rowindex -1 , colindex,visited)||
                    dfs(index + 1, board, word, rowindex , colindex -1,visited));

            visited[rowindex][colindex]  = false;
            return res;

        }
    }
}
