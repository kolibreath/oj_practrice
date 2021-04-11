public class 找树左下角的值 {
   class Solution {
        public int findBottomLeftValue(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int last = queue.size();
            int leftVal = root.val;
            while(!queue.isEmpty()){
                TreeNode cur = queue.poll();
                last --;
                TreeNode left = cur.left;
                TreeNode right = cur.right;
                if (left != null) queue.add(left);
                if (right!= null) queue.add(right);
                if (last == 0 && !queue.isEmpty()) {
                    last = queue.size();
                    leftVal = queue.get(0).val;
                }
            }
            return leftVal;
        }
    }
}