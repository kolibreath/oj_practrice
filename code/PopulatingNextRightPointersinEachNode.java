import java.util.LinkedList;

public class PopulatingNextRightPointersinEachNode {

   static public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

  static   public class Solution {
        public void connect(TreeLinkNode root) {
            if(root == null)
                return;
            if(root.left== null || root.right == null){
                return;
            }

            Bfs(root);
        }

        private void Bfs(TreeLinkNode root){
            LinkedList<TreeLinkNode> list = new LinkedList<>();
            list.add(root);
            boolean flag = true;
            while(!list.isEmpty()&&flag){
                int size = list.size();
                for(int i= 0;i<size;i++){
                    TreeLinkNode node = list.poll();
                    if(node.left == null){
                        flag = false;
                        break;
                    }
                    list.add(node.left);
                    list.add(node.right);
                }

                for(int i=0;i<list.size();i++){
                    if(i == list.size() -1){
                        break;
                    }
                    list.get(i).next = list.get(i+1);
                }
            }
        }
    }
}
