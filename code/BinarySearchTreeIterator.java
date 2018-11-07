import java.util.LinkedList;

public class BinarySearchTreeIterator {
    LinkedList<TreeNode> list = new LinkedList<>();
    private int index = 0;
    public class BSTIterator {

        private void iterate(TreeNode root){
            if(root == null)
                return;
            iterate(root.left);
            list.add(root);
            iterate(root.right);
        }

        public BSTIterator(TreeNode root) {
            iterate(root);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return index < list.size();
        }

        /** @return the next smallest number */
        public int next() {
            return list.get(index++).val;
        }
    }
}
