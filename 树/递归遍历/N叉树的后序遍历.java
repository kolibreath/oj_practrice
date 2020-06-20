import java.util.LinkedList;
import java.util.List;

public class N叉树的后序遍历 {
    class Solution {
        List<Integer> result = new LinkedList<>();
        public void helper(Node node){
            if(node == null) return ;
            for (int i = 0; i < node.children.size(); i++) {
                helper(node.children.get(i));
            }
            result.add(node.val);
        }
        public List<Integer> postorder(Node root) {
            helper(root);
            return result;
        }
    }
}
