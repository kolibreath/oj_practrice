import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 输出二叉树 {
    class Solution {
        private int height(TreeNode node){
            if(node == null) return 0;
            return Math.max(height(node.left), height(node.right)) + 1;
        }

        private void fill(TreeNode node, int level, String[][] res,int left, int right){
            if(node == null) return;
            res[level][(left + right) / 2] = String.valueOf(node.val);
            fill(node.left, level + 1 , res, left, (left + right)/2);
            fill(node.right, level + 1, res, (left + right + 1) / 2, right);
        }
        public List<List<String>> printTree(TreeNode root) {
            int height = height(root);
            String [][] res = new String[height][(1 << height) - 1];
            for (String arr[]: res) Arrays.fill(arr, "");
            //注意一下下标的问题
            fill(root, 0, res, 0, res[0].length);

            LinkedList<List<String>>  result = new LinkedList<>();
            for (String arr []: res) result.add(Arrays.asList(arr));
            return result;
        }
    }
}