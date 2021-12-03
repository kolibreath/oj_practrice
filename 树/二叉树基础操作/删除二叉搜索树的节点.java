public class 删除二叉搜索树的节点 {

    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            if(root.val > key) {
                root.left = deleteNode(root.left, key);
            }else if(root.val < key) {
                root.right = deleteNode(root.right, key);
            }else {
                if(root.left == null && root.right == null) root = null;
                else if(root.right != null) {
                    int suc = suc(root);
                    root.val = suc;
                    root.right = deleteNode(root.right, suc);
                }else {
                    int pre = pre(root);
                    root.val = pre;
                    root.left = deleteNode(root.left, pre);
                }
            }
            return root;
        }

        private int pre(TreeNode root) {
            TreeNode p = root.left;
            while(p.right != null) p = p.right;
            return p.val;
        }

        private int suc(TreeNode root) {
            TreeNode p = root.right;
            while(p.left != null) p = p.left;
            return p.val;
        }

    }
}
