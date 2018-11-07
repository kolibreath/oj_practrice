import java.util.ArrayList;
import java.util.List;

public class N_aryTreePreorderTraversal {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    static class Solution {
        public List<Integer> preorder(Node root) {
            if(root == null)
                return new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            preorder(root,result);

            return result;
        }

        public void preorder(Node root, List<Integer> list){
            if(root == null)
                return;
            list.add(root.val);
            if(root.children!=null)
                for(int i=0;i<root.children.size();i++){
                    preorder(root.children.get(i),list);
                }
        }
    }
}
