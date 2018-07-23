public class WordSearchWrongWay {

    //this way is completely wrong ignoring adjacent
    static class Solution {
        public boolean exist(char[][] board, String word) {

            if(board ==null || board.length ==0 || board[0].length ==0)
                return false;

            int flatBoard[] = new int[100];
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    flatBoard[board[i][j] - 48]++;
                }
            }

            boolean flag = true;
            for (int i= 0;i<word.length();i++){
                    flatBoard[word.charAt(i) - 48]--;
                    if(flatBoard[word.charAt(i) - 48]<0){
                        flag = false;
                        break;
                }
            }

            return flag;
        }
    }
}
