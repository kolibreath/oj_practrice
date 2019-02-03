import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EscapeTheGhost {
    static class Solution {
        public boolean escapeGhosts(int[][] ghosts, int[] target) {
            if(ghosts == null || target == null || ghosts.length == 0)
                return false;
            int max = Integer.MAX_VALUE;
            for(int i=0;i<ghosts.length;i++){
                int x = ghosts[i][0],y = ghosts[i][1];
                int shortest = Math.abs(x - target[0]) + Math.abs(y - target[1]);
                if(shortest < max)
                    max = shortest;
            }

            int mine = Math.abs(target[0]) + Math.abs(target[1]);
            if( max <= mine)
                return false;
            else{
                return true;
            }
        }
    }
}
