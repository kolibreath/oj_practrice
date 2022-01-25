public class 最接近的二叉搜索树值 {


    class Solution {
        public int closestValue(TreeNode root, double target) {
            int val, closest = root.val;
            while (root != null) {
                val = root.val;
                closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
                root = target < root.val ? root.left : root.right;
            }
            return closest;
        }
    }
}
