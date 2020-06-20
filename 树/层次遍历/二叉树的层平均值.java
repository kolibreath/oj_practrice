import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层平均值 {
    static class Solution {

        public List<Double> averageOfLevels(TreeNode root) {
            LinkedList<LinkedList<Integer>> result = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                LinkedList<Integer> integers = new LinkedList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    integers.add(node.val);
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }
                result.add(integers);
            }
            LinkedList<Double> r = new LinkedList<>();
            for (LinkedList<Integer> list: result) {
                long sum = 0;
                for (Integer integer : list) {
                    sum += integer;
                }
                double  d = (sum + 0.0) / list.size();
                r.add(d);
            }
            return r;
        }
    }
}
