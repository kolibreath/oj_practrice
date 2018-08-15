public class ConstructStringFromBinaryTree {

    static public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode() { }
    }

    static class Solution {
        public String str = "";
        public String tree2str(TreeNode t) {
            if(t == null)
                return new String();

            constructString(t);

            return str.substring(1,str.length()-1);
        }

        //root cannot be the first one
        public void constructString(TreeNode root){

            if(root == null) {
                return;
            }

            str += "(" + root.val;
            if (root.left==null && root.right!=null) str += "()";
            constructString(root.left);
            constructString(root.right);
            str += ")";
        }
    }

}
