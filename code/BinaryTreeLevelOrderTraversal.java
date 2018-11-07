import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root == null)
                return new LinkedList<>();

            List<List<Integer>> list = new LinkedList<>();
            createLevel(root,list);

            return list;
        }

        void createLevel(TreeNode root,List<List<Integer>> list){

            LinkedList<TreeNode> queue = new LinkedList<>();
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);

            list.add(temp);

            queue.add(root);
            while(!queue.isEmpty()){

                LinkedList<TreeNode> tempQueue = new LinkedList<>(queue);
                List<Integer> level = new LinkedList<>();

                queue.clear();

                while(!tempQueue.isEmpty()){
                    TreeNode cur= tempQueue.poll();

                    TreeNode left = cur.left;
                    TreeNode right  = cur.right;

                    if(left != null){
                        queue.add(left);
                        level.add(left.val);
                    }

                    if(right!=null){
                        level.add(right.val);
                        queue.add(right);
                    }
                }

                if(level.size()!=0)
                    list.add(level);

            }
        }
    }

}
