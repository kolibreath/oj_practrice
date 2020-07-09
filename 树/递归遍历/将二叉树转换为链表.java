public class 将二叉树转换为链表 {
    class Solution {
        public void flatten(TreeNode root) {
            if(root == null)return ;
            flatten(root.left);
            flatten(root.right);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null) root = root.right;
            root.right = temp;
        }
    }
}