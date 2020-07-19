import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 具有所有最深节点的最小子树 {
    static class Solution {
        private int[] preorder;
        private int[] inorder;

        //全局的index 避免回溯时会造成不必要的麻烦
        private int index = 0;

        private int node(int target, int low, int high){
            for (int i = low; i <= high; i++) {
                if(target == inorder[i]) return i;
            }
            return -1;
        }
        //low和high是在inorder中起作用的
        private TreeNode dfs(int low, int high){
            if(low > high) return null;
            if(index == preorder.length ) return null;
            int target = preorder[index++];
            if(low == high) return new TreeNode(inorder[high]);
            //以前序遍历的这一个数值作为中点
            int inorderIndex = node(target, low, high);
            TreeNode mid = new TreeNode(target);
            mid.left = dfs(low, inorderIndex-1);
            mid.right = dfs(inorderIndex+1, high);
            return mid;
        }
        public TreeNode bstFromPreorder(int[] preorder) {
            this.preorder = preorder;
            this.inorder  = Arrays.copyOf(preorder, preorder.length);
            Arrays.sort(inorder);

            return dfs(0, inorder.length -1);
        }
    }
}