import java.util.LinkedList;
import java.util.Stack;

public class SumRoot2LeafNodes {
   static class Solution {
        public int sumNumbers(TreeNode root) {
            return getSum(root,0);
        }

        private int getSum(TreeNode root,int pre){
            if(root == null) return 0;
            if(root.left == null|| root.right == null) return root.val + pre * 10;
            return getSum(root.left,pre*10 + root.val) + getSum(root.right,pre*10 + root.val);
        }
    }
}
