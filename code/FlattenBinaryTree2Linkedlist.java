import java.util.LinkedList;

public class FlattenBinaryTree2Linkedlist {

   static class Solution {
        public void flatten(TreeNode root) {
            LinkedList<TreeNode> list = new LinkedList<>();
            traverseAdd(root,list);

            if(root == null)
                return;

            if(root.right==null && root.left ==null)
                return;
            TreeNode pointer = root;
            for(int i =1;i<list.size();i++){
                pointer.right = list.get(i);
                pointer = pointer.right;
            }
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
