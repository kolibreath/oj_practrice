import java.util.LinkedList;

public class CourseScheduleii {
   public static class Solution {
        public int[] findOrder(int n,int[][] courses) {
            if (courses == null)
                return new int[]{0};
            int numCours = courses.length;
            if(courses.length == 0)
                return new int[]{0};
            int degree [] = new int[n];

            //构建入度
            for (int[] course : courses) {
                degree[course[1]]++;
            }

            //最好构建一个数组list 从下标获取数值
            //构建dag
            LinkedList<Integer>[] list = new LinkedList[n];
            for (int i = 0; i < n ; i++) {
                list[i] = new LinkedList<>();
            }

            for (int i = 0; i < numCours ; i++) {
                list[courses[i][0]].add(courses[i][1]);
            }

            //BFS 遍历一下
            LinkedList<Integer> queue = new LinkedList<>();

            //先去除入度为0 的节点
            for(int i = 0;i< n;i++)
                if(degree[i] == 0)
                    queue.add(i);

            LinkedList<Integer> stack = new LinkedList<>();
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                stack.push(cur);
//                degree[courses[][1]]
                if (list[cur].size() != 0) {
                    int next = list[cur].getFirst();
                    queue.add(next);
                }
            }

            int order[] = new int[stack.size()];
            for (int i = 0; i < order.length ; i++) {
                order[i] = stack.pop();
            }

            return order;
        }
    }
}
