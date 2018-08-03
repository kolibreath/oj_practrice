import betterSolution.SameTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            if(root == null)
                return new ArrayList<>();
            List<String> result = new ArrayList<>();
            createPath(root,"",result);

            return result;
        }

        public void createPath(TreeNode root,String path,List<String> result){
            if(root == null)
                return;

            if(root.left == null && root.right == null){
                result.add(path + root.val);
            }
            if(root.left != null)
                createPath(root.left,path + root.val + "->" ,result);
            if(root.right!= null)
                createPath(root.right,path + root.val + "->" ,result);
        }
    }
}
