import java.util.LinkedList;
import java.util.List;

// 这个题可以用来讲递归的原理
public class 二叉树中的伪回文路径 {
    class Solution {
        private int ans = 0;
        private void dfs(TreeNode node, int temp){
            temp = temp ^ (1 << node.val);
            if(node.left == null &&  node.right == null)
                if(temp == 0 || (temp & (temp - 1)) == 0)
                    ans ++;
            if(node.left != null) dfs(node.left,temp);
            if(node.right!= null) dfs(node.right,temp);
        }
        public int pseudoPalindromicPaths (TreeNode root) {
            if(root == null) return 0;
            dfs(root,0);
            return ans;
        }
    }
}
