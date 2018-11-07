public class ConvertSortedArray2BinarySearchTree {

        public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

    class Solution {

        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArray2BST(nums,0,nums.length-1);
        }

        public TreeNode sortedArray2BST(int []nums,int left,int right){
            if(left > right) return null;

            int mid =  left + (right -left )/2;

            TreeNode cur = new TreeNode(nums[mid]);
            cur.left = sortedArray2BST(nums,left,mid -1);
            cur.right = sortedArray2BST(nums,mid + 1,right );

            return cur;
        }
    }

}
