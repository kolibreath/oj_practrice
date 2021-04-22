public class 后继者{
    class Solution {
        public TreeNode inorderSuccessor(TreeNode cur, TreeNode p) {
            if (cur == null) return null;

            if (cur.val <= p.val)   return inorderSuccessor(cur.right,p);
            else{
                TreeNode leftNode =inorderSuccessor(cur.left,p);
                if (leftNode == null) return cur;
                else return leftNode;
            }
        }

    }
}
