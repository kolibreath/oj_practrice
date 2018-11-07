public class PopulatingNextRightPointersInEachNode {

  public class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }

    public class Solution {
        public void connect(TreeLinkNode root) {
            if(root == null)
                return;
            if(root.left == null || root.right == null)
                return;

            TreeLinkNode start = root;
            TreeLinkNode cur;
            while(start.left != null){
                cur = start;
                while(cur != null){
                    cur.left.next = cur.right;
                    if(cur.next != null){
                        cur.right.next = cur.next.left == null?
                                cur.next.right : cur.next.left;
                    }
                    cur = cur.next;
                }
                start = start.left;
            }
        }

    }
}
