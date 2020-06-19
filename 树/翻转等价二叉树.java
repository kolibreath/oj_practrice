public class 翻转等价二叉树 {
    class Solution {
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            //递归终止条件
            if(root1==null&&root2==null)
                return true;
            if(root1==null||root2==null||root1.val!=root2.val)
                return false;

//处理只存在一个孩子
            if(root1.left==null&&root2.left==null)
                return flipEquiv(root1.left,root2.left)&&flipEquiv(root1.right,root2.right);
            if(root1.left==null||root2.left==null)
                return flipEquiv(root1.left,root2.right)&&flipEquiv(root1.right,root2.left);

//处理左右孩子都存在/都不存在
            if(root1.left!=null&&root2.right!=null &&root1.left.val!=root2.left.val)
                return flipEquiv(root1.left,root2.right)&&flipEquiv(root1.right,root2.left);
            return flipEquiv(root1.left,root2.left)&&flipEquiv(root1.right,root2.right);

        }
    }
}
