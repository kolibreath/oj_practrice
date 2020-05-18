import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class 课程表II {
    //https://leetcode-cn.com/problems/course-schedule-ii/
    //一道拓扑排序的问题
     class Solution {
        private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        private int visited[] ;
        private int status[] = {0,1,2};

        //如果遍历过程中出现了环的情况
        private boolean invalid = false;
        private LinkedList<Integer> stack = new LinkedList<>();
        //主要的dfs算法，使用栈保存迭代的情况
        private void dfs(int index){
            visited[index] = status[1];
            ArrayList<Integer> connected = graph.get(index);
            for (Integer sub : connected){
                //如果是未搜索的状态 直接进行递归
                if(visited[sub] == status[0]){
                    dfs(sub);
                    if(invalid) return;
                }
                //如果是搜索中的状态 出现了环路（最简单的情况是衔尾蛇）
                if(visited[sub] == status[1]){
                    invalid = true;
                    return;
                }
            }
            visited[index] = status[2];
            stack.add(index);
        }

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            visited = new int[numCourses];
            //初始化graph
            for (int i = 0; i< numCourses ; i++) {
                graph.add(new ArrayList<>());
                visited[i] = 0;
            }

            for (int i = 0; i < prerequisites.length ; i++) {
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            //遍历每一个起
            for (int i = 0; i < numCourses; i++) {
                if(visited[i]== status[2])
                    continue;
                dfs(i);
            }

            if(invalid)
                return new int[0];

            int result[] = new int[numCourses];
            Collections.reverse(stack);
            for (int i = 0; i < stack.size(); i++) {
                result[i] = stack.get(i);
            }

            return result;
        }
    }

}
