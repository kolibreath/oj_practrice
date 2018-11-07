import java.util.ArrayList;
import java.util.List;

public class TrimABinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    static class Solution {
//        private List<Integer> list  = new ArrayList<>();
//        public TreeNode trimBST(TreeNode root, int L, int R) {
//            if(root == null)
//                return null;
//            traverseTree(root);
//            List<Integer> leftList = new ArrayList<>();
//            for(int i:list){
//                if(i<=R && i>= L)
//                  leftList.add(i);
//            }
//
//            TreeNode node = new TreeNode(leftList.get((leftList.size() -1)/2));
//            node = constructTree(node,0,leftList.size()-1,leftList);
//            return  node;
//        }
//
//        public TreeNode constructTree(TreeNode root,int low,int high,List<Integer> list){
//            if(low < 0 || high >= list.size() || low > high)
//                return null;
//
//            int mid = (low + high)/2;
//            root = new TreeNode(list.get(mid));
//            root.left = constructTree(root.left,low,mid-1,list);
//            root.right= constructTree(root.right,mid + 1, high,list);
//
//            return root;
//        }
//
//        public void traverseTree(TreeNode root){
//            if(root == null)
//                return;
//            traverseTree(root.left);
//            list.add(root.val);
//            traverseTree(root.right);
//        }
//    }


    static class Solution{

        public TreeNode trimBST(TreeNode root, int L, int R) {
            if(root == null)
                return null;
            else if(root.val < L){
                return trimBST(root.left,L,R);
            }else if(root.val > R){
                return trimBST(root.right,L,R);
            }else{
                root.left = trimBST(root.left,L,R);
                root.right= trimBST(root.right,L,R);

                return root;
            }
        }
    }

}
