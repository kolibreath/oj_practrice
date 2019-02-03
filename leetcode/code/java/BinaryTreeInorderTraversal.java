import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            traverse(root,list);
            return list;
        }

        public void traverse(TreeNode node,List<Integer> list){
            if(node == null){
                return;
            }
            traverse(node.left,list);
            list.add(node.val);
            traverse(node.right,list);
        }
        
    }


}
