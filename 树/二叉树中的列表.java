public class 二叉树中的列表 {
    class Solution {
        private boolean dfs(TreeNode node, ListNode cur){
            if(cur == null) return true;
            if(node == null ) return false;
            if(node.val != cur.val) return false;
            return dfs(node.left, cur.next) || dfs(node.right, cur.next);
        }
        public boolean isSubPath(ListNode head, TreeNode root) {
            if(root == null) return false;
            return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
        }
    }
}
