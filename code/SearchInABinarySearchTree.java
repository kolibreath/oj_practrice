
public class SearchInABinarySearchTree {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if(root == null)
                return null;
            return getValue(root,val);
        }

        public TreeNode getValue(TreeNode root,int val){
            if(root == null)
                return null;
            if(root.val < val){
                return getValue(root.right,val);
            }else if(root.val > val){
                return getValue(root.left,val);
            }else{
                return root;
            }
        }
    }
}
