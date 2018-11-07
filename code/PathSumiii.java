import java.util.ArrayList;
import java.util.List;

public class PathSumiii {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        int counter=0;
        public int pathSum(TreeNode root, int sum) {
            if(root==null)return 0;
            DFS(root,sum);
            pathSum(root.left,sum);
            pathSum(root.right,sum);
            return counter;
        }

        private void DFS(TreeNode node,int sum){
            if(node==null){
                return;
            }
            if(sum-node.val==0){
                counter++;
            }
            DFS(node.left,sum-node.val);
            DFS(node.right,sum-node.val);

        }
    }
}
