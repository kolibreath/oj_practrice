import java.util.ArrayList;
import java.util.List;

public class BalancedBinaryTree {

  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    static class Solution  {
        public boolean isBalanced(TreeNode root) {
            if(root == null)
                return true;

            List<Integer> depths = new ArrayList<>();
            getDepths(depths,root,0);

            int max = depths.get(0), min = depths.get(0);
            for(int i : depths){
                if(i > max)
                    max = i;
                if(i < min)
                    min = i;
            }

            return max - min <= 1;
        }

        public void getDepths(List<Integer> depths, TreeNode root,int counter){

            counter++;
            if(root.left ==null && root.right == null) {
                depths.add(counter);
                return;
            }
            getDepths(depths,root.left,counter);
            getDepths(depths,root.right,counter);
            return;
        }


    }
}
