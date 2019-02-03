import java.util.LinkedList;

public class FlattenBinaryTree2Linkedlist {

   static class Solution {
        public void flatten(TreeNode root) {
            LinkedList<TreeNode> list = new LinkedList<>();
            traverseAdd(root,list);

            if(root == null)
                return ;

            if(root.right==null && root.left ==null)
                return ;

            TreeNode pointer = root;
            for(int i =1;i<list.size();i++){
                TreeNode cp  = new TreeNode(list.get(i).val);
                pointer.right = cp;
                pointer = pointer.right;
            }

            clearNode(root.left);

            root.left = null;
        }

        void clearNode(TreeNode node){
            if(node == null)
                return;

            TreeNode left=  node.left;
            TreeNode right = node.right;

            clearNode(left);
            clearNode(right);

            node.left = null;
            node.right = null;
        }

        void traverseAdd(TreeNode root, LinkedList<TreeNode> list){
            if(root== null)
                return;
            list.add(root);
            traverseAdd(root.left,list);
            traverseAdd(root.right,list);
        }
    }
}
