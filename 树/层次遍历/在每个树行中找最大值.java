import java.util.LinkedList;
import java.util.List;

public class 在每个树行中找最大值 {
    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            if(root == null) return new LinkedList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            LinkedList<Integer> result = new LinkedList<>();

            while(!queue.isEmpty()){
                int max = Integer.MIN_VALUE;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.poll();
                    if(max < temp.val) max = temp.val;
                    if(temp.left!=null) queue.add(temp.left);
                    if(temp.right!=null) queue.add(temp.right);
                }
                result.add(max);
            }
            return result;
        }
    }
}