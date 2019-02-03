import java.util.ArrayList;
import java.util.List;

public class N_aryTreePostorderTraversal {
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
    class Solution {
        public List<Integer> postorder(Node root) {
            if(root == null)
                return new ArrayList<>();

            List<Integer> list = new ArrayList<>();
            postorder(root,list);
            return list;
        }

        public void postorder(Node root, List<Integer> list){
            if(root == null) {
                return;
            }
            if(root.children!=null) {
                for (int i = 0; i < root.children.size(); i++) {
                    postorder(root.children.get(i), list);
                }
            }
            list.add(root.val);
        }
    }
}
