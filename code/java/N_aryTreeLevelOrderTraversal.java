import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_aryTreeLevelOrderTraversal {


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
            public List<List<Integer>> levelOrder(Node root) {

                if(root ==null){
                    return  new ArrayList<>();
                }
                Queue<Node> list = new LinkedList<>();
                list.add(root);

                List<List<Integer>> result = new ArrayList<>();

                List<Integer> temp = new ArrayList<>();
                temp.add(root.val);
                result.add(temp);

                while(!list.isEmpty()){

                    int cnt = list.size();

                    List<Integer> list_value = new ArrayList<>();
                    for(int i=0;i<cnt;i++){

                        Node node = list.poll();
                        List<Node> children = node.children;

                        if(children ==null)
                            continue;

                        for(Node n:children){
                            list.add(n);
                            list_value.add(n.val);
                        }
                    }

                    if(list_value.isEmpty())
                        continue;
                    result.add(list_value);

                }

                return result;
            }
    }
}
