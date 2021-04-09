public class 从中序与后序遍历序列中构造二叉树 {
   class Solution {
        private int index ;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            index = postorder.length -1;
            return dfs(inorder, postorder, 0, inorder.length-1);
        }

        public TreeNode dfs(int [] inorder, int[]postorder, int start, int end) {
            if (start > end || index <0 ) return null;
            int val = postorder[index--];
            int i ;
            for (i = start; i < end ; i++)
                if (inorder[i] == val)
                    break;

            TreeNode root = new TreeNode(val);
            root.right = dfs(inorder, postorder,i+1, end);
            root.left = dfs(inorder, postorder, start , i - 1);

            return root;
        }
    }

}