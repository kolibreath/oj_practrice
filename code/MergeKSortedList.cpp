public class ConstructBinaryTree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder,inorder,0,preorder.length - 1,0, inorder.length - 1);
        }

        public TreeNode buildTree(int []preorder,int []inorder,int preStart,int preEnd,int inStart,int inEnd){

            if(preStart > preEnd || inStart > inEnd){
                return null;
            }

            int rootVal = preorder[preStart];
            int rootIndex = 0;
            for(int i = inStart;i<=inEnd;i++){
                if(rootVal == inorder[i]){
                    rootIndex = i;   break;

                }
            }

            int len = rootIndex - inStart;
            TreeNode node = new TreeNode(rootVal);

            node.left = buildTree
                    (preorder,inorder,preStart + 1, preStart + len, inStart ,rootIndex - 1);

            node.right = buildTree(preorder,inorder,preStart + len + 1,preEnd,rootIndex + 1,inEnd);

            return node;
        }
    }


    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
}
