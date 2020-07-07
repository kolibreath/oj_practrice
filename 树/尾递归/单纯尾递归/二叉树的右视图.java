import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的右视图 {
    class Solution {
        private LinkedList<Integer> result = new LinkedList<>();
        public List<Integer> rightSideView(TreeNode root) {
            if(root == null) return new LinkedList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            result.add(root.val);

            while(!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size ; i++) {
                    TreeNode temp = queue.poll();
                    if(temp.left != null) queue.add(temp.left);
                    if(temp.right!= null) queue.add(temp.right);
                }
                if(!queue.isEmpty()) result.add(queue.getLast().val);
            }
            return result;
        }
    }
}
