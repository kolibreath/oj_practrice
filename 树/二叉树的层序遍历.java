import java.util.LinkedList;
import java.util.List;

public class 二叉树的层序遍历 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root == null) return new LinkedList<>();
            List<List<Integer>> result = new LinkedList<>();
            LinkedList<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            while(!nodes.isEmpty()){
                List<Integer> list = new LinkedList<>();
                int n = nodes.size();
                while(n -- > 0){
                    TreeNode cur = nodes.poll();
                    list.add(cur.val);
                    if(cur.left != null ) nodes.add(cur.left);
                    if(cur.right!= null ) nodes.add(cur.right);
                }
                result.add(list);
            }
            return result;
        }
    }
}
