import java.util.ArrayList;
import java.util.List;

public class MaximumDepthofBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null)
                return 0;

            List<Integer> list = new ArrayList<>();
            getMaximumDepth(root,0,list);
            int max = list.get(0);
            for(int i=1;i<list.size();i++)
                if(list.get(i) > max)
                    max = list.get(i);

            return max;

        }

        public void getMaximumDepth(TreeNode root, int depth,List<Integer> list){
            depth ++;
            if(root.left == null && root.right == null){
                list.add(depth);
            }

            if(root.left != null)
                getMaximumDepth(root.left,depth,list);
            if(root.right != null)
                getMaximumDepth(root.right,depth,list);
        }
    }
}
