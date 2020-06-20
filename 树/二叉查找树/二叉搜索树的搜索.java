public class 二叉搜索树的搜索 {
    class Solution {
        //带有返回值的递归搜索
        public TreeNode searchBST(TreeNode root, int val) {
            if(root == null || root.val == val) return root;
            return root.val < val ? searchBST(root.right,val) :searchBST(root.left, val);
        }
    }
}
