import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> rootList1 = new ArrayList<>();
            List<Integer> rootList2 = new ArrayList<>();

            dfs(root1,rootList1);
            dfs(root2,rootList2);

            if(rootList1.size() != rootList2.size())
                return false;

            for(int i=0;i<rootList1.size() && i< rootList2.size();i++){
                if(!rootList1.get(i).equals(rootList2.get(i)))
                    return false;
            }

            return true;
        }

        public void dfs(TreeNode root,List<Integer> list){
            if(root.left == null && root.right == null) {
                list.add(root.val);
                return;
            }
            if(root.left != null)
                dfs(root.left,list);

            if(root.right!= null)
                dfs(root.right,list);
        }
    }
}
