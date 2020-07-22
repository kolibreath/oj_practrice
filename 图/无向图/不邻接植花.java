import java.util.ArrayList;

public class 不临接植花 {
    static class Solution {
        public int[] gardenNoAdj(int N, int[][] paths) {
            //将二维数组转换为邻接表结构
            ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[N+1];
            for (int i = 0; i < N+1; i++) graph[i] = new ArrayList<>();
            for (int path[]: paths) {
                graph[path[0]].add(path[1]);
                graph[path[1]].add(path[0]);
            }
            //完成转换为邻接表
            int result[] = new int[N];
            int count = 0;
            while(++count <= N){
                //查看邻接的花园中的节点使用的是那些颜色
                boolean used[] = new boolean[5];
                ArrayList<Integer> linked = graph[count];
                //根据邻接表中的元素使用过的颜色
                for (int i: linked) used[result[i-1]] = true;
                //查看剩余的颜色
                for (int i = 1; i <= N ; i++) {
                    if(!used[i]){
                        result[count - 1] = i;
                        break;
                    }
                }
            }
            return result;
        }
    }
}