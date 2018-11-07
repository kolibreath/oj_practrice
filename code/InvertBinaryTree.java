public class InvertBinaryTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
         helper(root);
         return root;
        }

        public void helper(TreeNode root){
            if(root== null)
                return ;

            TreeNode node = new TreeNode(root.val);
            node = root.left;
            root.left = root.right;
            root.right = node;

            helper(root.left);
            helper(root.right);
        }
    }
}
