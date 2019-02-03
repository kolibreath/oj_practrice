import java.util.ArrayList;
import java.util.List;

public class SumOfLeftLeaves {


   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if(root == null)
                return 0;

            List<Integer> list = new ArrayList<>();
            helper(root,list,true);

            int sum = 0;

            for(int i : list){
                sum += i;
            }

            return sum;
        }

        public void helper(TreeNode root, List<Integer> list,boolean left){
            if(root.left == null && root.right == null && left){
                list.add(root.val);
            }

            if(root.left != null)
                helper(root.left,list,true);
            if(root.right  != null)
                helper(root.right,list,false);
        }
    }

}
