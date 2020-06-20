import java.util.LinkedList;
import java.util.List;

public class 从上到下打印二叉树II {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            if(root != null)
                queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                LinkedList<Integer> temp = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    temp.add(node.val);
                    if(node.left != null) queue.add(node.left);
                    if(node.right!=null) queue.add(node.right);
                }
                result.add(temp);
            }
            return result;
        }
    }
}
