import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllNodesDistanceKinBinaryTree {
    static class Solution {
    private  int level = 0;
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer>result = new LinkedList<>();
            findLevel(target.val,root);
            int l1 = Math.abs(level - K);
            int l2 = level + K;
            findLevel(result,l1,l2,root);
            result.remove((Integer)target.val);
            return result;
        }

        public void findLevel(List<Integer>result,int l1,int l2,TreeNode root){
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int curLevel = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0;i<size;i++){
                    TreeNode node = queue.poll();
                    if(node.left != null)
                        queue.add(node.left);
                    if(node.right != null)
                        queue.add(node.right);
                    if(curLevel == l1 || curLevel == l2){
                        result.add(node.val);
                    }
                }
                curLevel++;
            }
        }

        public void findLevel(int target,TreeNode root){
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean flag = false;
            while(!queue.isEmpty()){
                int size = queue.size();

                for(int i = 0;i<size;i++) {
                    TreeNode node = queue.poll();
                    if(node.val == target) {
                        flag = true;
                        break;
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                if (flag){
                    break;
                }
                level ++;
            }
        }
    }
}
