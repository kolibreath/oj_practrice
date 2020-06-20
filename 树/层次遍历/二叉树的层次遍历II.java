import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层次遍历II {
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if(root == null) return new LinkedList<>();
            List<List<Integer>> result =  new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if(root!=null)
                queue.add(root);
            while(!queue.isEmpty()){
                LinkedList<Integer> temp = new LinkedList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    temp.add(node.val);
                    if(node.left  !=null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }
                result.add(temp);
            }
            Collections.reverse(result);
            return  result;
        }
    }
}
