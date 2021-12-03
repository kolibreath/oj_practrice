public class 后继者 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        // recursive
//        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//            if(root == null || p == null) return null;
//            if(root.val <= p.val) return inorderSuccessor(root.right, p);
//            else {
//                TreeNode left = inorderSuccessor(root.left, p);
//                if(left != null) return left;
//                else return root;
//            }
//        }

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if(root == null) return null;
            if(p.right != null) {
                TreeNode q = p.right;
                while(q.left != null) q = q.left;
                return q;
            } else {
                TreeNode leftRoot = null;
                while(root != null) {
                    if(root.val <= p.val) root = root.right;
                    else {
                        leftRoot = root;
                        root = root.left;
                    }
                }
                return leftRoot;
            }
        }
    }
}
