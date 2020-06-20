public class 将有序数组变成二叉查找树 {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return create(0, nums.length - 1, nums);
        }

        private TreeNode create(int left, int right, int nums[]){
            if(left > right) return null;
            int middle = (left + right) / 2;
            TreeNode node = new TreeNode();
            node.val = nums[middle];

            node.left = create(left, right -1, nums);
            node.right = create(left + 1, right, nums);
            return node;
        }
    }
}
