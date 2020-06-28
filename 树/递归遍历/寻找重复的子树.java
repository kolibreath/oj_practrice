import java.util.*;

public class 寻找重复的子树 {
    class Solution {
        int t;
        Map<String, Integer> trees;
        Map<Integer, Integer> count;
        List<TreeNode> ans;

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            t = 1;
            trees = new HashMap();
            count = new HashMap();
            ans = new ArrayList();
            lookup(root);
            return ans;
        }

        public int lookup(TreeNode node) {
            if (node == null) return 0;
            String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
            int uid = trees.computeIfAbsent(serial, x-> t++);
            count.put(uid, count.getOrDefault(uid, 0) + 1);
            if (count.get(uid) == 2)
                ans.add(node);
            return uid;
        }
    }

}
