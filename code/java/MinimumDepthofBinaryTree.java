import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumDepthofBinaryTree {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //只要保持稳住 层级就好
    static class Solution {
        public int minDepth(TreeNode root) {
            int min = Integer.MAX_VALUE;

            if(root == null)
                return 0;

            int counter  = 1;
            Queue<TreeNode> queue = new LinkedList<>();

            root.val = counter;
            queue.add(root);


            while(!queue.isEmpty()){
                TreeNode n = queue.poll();
                counter = n.val;

                boolean leftNull = false;
                boolean rightNull = false;

                if(n.left !=null){
                    n.left.val =      counter + 1;
                    queue.add(n.left);
                }  else{
                    leftNull = true;
                }

                if(n.right !=null) {
                    n.right.val     = counter + 1;
                    queue.add(n.right);
                }else{
                    rightNull = true;
                }

                if(leftNull && rightNull){
                       if(n.val<min){
                           min = n.val;
                       }
                }

            }
            return min;
        }
    }
}
