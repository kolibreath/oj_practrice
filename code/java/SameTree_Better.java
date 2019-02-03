public class SameTree_Better {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution{

        public boolean isSameTree(TreeNode p,TreeNode q){
            if(p == null && q == null)
                return true;

        if( (p !=null && q==null) || (p == null && q != null) || p.val != q.val )
            return false;

        return isSameTree(p,q);
        }
    }
}
