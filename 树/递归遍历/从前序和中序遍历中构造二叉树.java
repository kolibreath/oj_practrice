public class 从前序和中序遍历中构造二叉树{
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return dfs(0, inorder.length, 0, preorder,inorder);
        }

        public TreeNode dfs(int start, int end, int index, int []preorder, int [] inorder){
            if(start <0 || end >= inorder.length) return null;
            int i = 0 ;
            for(i = start; i < end ; i++)
                if (preorder[index] == inorder[i]) 
                    break;
            // start end 分别表示中序遍历 index表示前序遍历\
            int val = inorder[i];
            TreeNode root = new TreeNode(val);
            root.left = dfs(start, i-1, index+1,preorder,inorder);
            root.right = dfs(i+1, end, index+1,preorder,inorder);
            return root;
        }
    }
}