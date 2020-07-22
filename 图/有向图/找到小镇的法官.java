public class 找到小镇的法官 {
    static class Solution {
        public int findJudge(int N, int[][] trust) {
            int ins[] = new int[N+1];
            int outs[] = new int[N+1];

            for (int i = 0; i < trust.length; i++) {
                outs[trust[i][0]]++;
                ins[trust[i][1]]++;
            }

            for (int i = 1; i <= N ; i++) {
                if(ins[i] == N - 1 && outs[i] == 0) return i;
            }
            return -1;
        }
    }
}