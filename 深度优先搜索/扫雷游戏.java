class Solution {
    //https://leetcode-cn.com/problems/minesweeper/
        public char[][] updateBoard(char[][] board, int[] click) {
            int x = click[0]; int y = click[1];
            if (board[x][y] == 'M'){
                board[x][y] = 'X';
                return board;
            }
            helper(board, click[0],click[1]);
            return board;
        }

        public void helper(char [][] board, int x, int y){
            //out of bounds
            int height = board.length; int width = board[0].length;
            // rule 2
            int cnt = 0;
            int[] dir1 = new int[]{0,0,-1,1,-1,1,1,-1};
            int[] dir2 = new int[]{-1,1,0,0,-1,1,-1,1};
            // rule 3
            if (board[x][y] == 'E'){
                // scan 8 blocks in vicinity
                for(int i =0;i < dir1.length;i++){
                    int xt = x + dir1[i];
                    int yt = y + dir2[i];
                    if (xt < 0 || yt < 0 || xt >= height || yt >= width) continue;
                    if (board[xt][yt] == 'M') cnt ++;
                }
            }
            if (cnt == 0){
                board[x][y] = 'B';
                // rule 4
                for(int i = 0;i < dir1.length;i++){
                    int xt = x + dir1[i];
                    int yt = y + dir2[i];
                    if (xt < 0 || yt < 0 || xt >= height || yt >= width ) continue;
                    if (board[xt][yt] != 'E') continue;
                    helper(board,xt,yt);
                }

            }
            else board[x][y] = (char)(cnt +'0');
        }
    }