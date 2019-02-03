import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if(prerequisites == null)
                return false;
            if(prerequisites.length == 0)
                return true;
            int degree[] = new int[numCourses];
            //求每个节点的入度
            for(int i = 0;i< prerequisites.length;i++){
                degree[prerequisites[i][1]]++;
            }

            //求当前入度为0 的节点
            Queue<Integer> queue = new LinkedList<>();
            for(int i= 0;i<numCourses;i++){
                if(degree[i] == 0)
                    queue.add(i);
            }

            int finishCount = queue.size();
            while(!queue.isEmpty()){
                int cur  = queue.remove();
                for(int i =0;i<prerequisites.length;i++){
                    if(prerequisites[i][0] == cur) {
                        degree[prerequisites[i][1]]--;

                        if(degree[prerequisites[i][1]] == 0){
                            finishCount++;
                            queue.add(prerequisites[i][1]);
                        }
                    }

                }
            }

            return finishCount == numCourses;
        }
    }
}
