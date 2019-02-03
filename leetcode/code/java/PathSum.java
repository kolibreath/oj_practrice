public class PathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution{
        public boolean hasPathSum(TreeNode root,int sum){
            if(root == null){
                return false;
            }
            boolean flags[] = new boolean[1];
            flags[0] = false;
            getSum(root,root.val,sum,flags);

            return flags[0];
        }

        public void getSum(TreeNode root,int sum,int tar,boolean flags[]){
            if(root == null)
                return;

            if(root.left== null && root.right ==null){
               if(  sum == tar){
                   flags[0] = true;
                   return;
               }else{
                   return;
               }
            }

            if(root.left !=null)
                getSum(root.left, sum+root.left.val,tar,flags);

            if(root.right != null)
                getSum(root.right,sum+root.right.val,tar,flags);

        }
    }
}
