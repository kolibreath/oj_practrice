import java.util.LinkedList;

public class 叶子相似的树 {
    class Solution {
        private void traverse(TreeNode node, LinkedList<Integer> leaves){
            if(node == null) return;
            if(node.left == null && node.right == null)
                leaves.add(node.val);
            traverse(node.left, leaves);
            traverse(node.right, leaves);
        }
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            LinkedList<Integer> l1 = new LinkedList<>();
            LinkedList<Integer> l2 = new LinkedList<>();

            traverse(root1,l1);
            traverse(root2,l2);

            if(l1.size() != l2.size()) return false;
            for (int i = 0; i < l1.size() ; i++) {
                if(!l1.get(i).equals(l2.get(i))) return false;
            }
            return true;
        }
    }
}
