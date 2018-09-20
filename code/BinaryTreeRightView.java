import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightView {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            right(result, root, 0);
            return result;
        }

        public void right(List<Integer> list, TreeNode root, int level) {
            if (root == null)
                return;
            if (level == list.size())
                list.add(root.val);
            right(list, root.right, level + 1);
            right(list, root.left, level + 1);
        }
    }
}
