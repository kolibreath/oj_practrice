public class 最大BST子树 {
    static class Solution {
        public int largestBSTSubtree(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int ans = 0;
        private void dfs(TreeNode node) {
            if (node == null) return ;
            if (isValidBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                ans = Math.max(ans, treeSize(node));
            }
            dfs(node.left);
            dfs(node.right);
        }

        // 第一步 找子树
        private boolean isValidBST(TreeNode node, int min, int max) {
            if (node == null) return true;
            if (node.val <= min || node.val >= max) return false;
            return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
        }

        // 第二步 统计数大小
        private int treeSize(TreeNode node) {
            if (node == null) return 0;
            return treeSize(node.left) + treeSize(node.right) + 1;
        }
    }

    static class Solution2 {
        public int largestBSTSubtree(TreeNode root) {
            dfs(root);
            return ans;
        }

        class Info {
            // 当前BST中的最大值
            int max;
            // 当前BST中的最小值
            int min;
            // 当前的BST的大小
            int size =0;
            // 当前BST的根节点
            TreeNode root;

            public Info(int max, int min, int size, TreeNode root) {
                this.max = max;
                this.min = min;
                this.size = size;
                this.root = root;
            }
        }

        private int ans = 0;
        private Info dfs(TreeNode node) {
            // BASE CASE
            if (node == null){
                return null;
            }
            if (node.left == null && node.right == null) {
                ans = Math.max(ans, 1);
                return new Info(node.val, node.val, 1, node);
            }

            Info left = dfs(node.left);
            Info right = dfs(node.right);
            // CASE#1 如果左右都为空
            if (left == null && right == null) {
                return null;
            } else if (left != null && right == null) {
                // 右子树不存在 或者右子树不是BST
                if (node.right == null) {
                    if (node.val > left.max) {
                        ans = Math.max(left.size + 1, ans);
                        return new Info(node.val, left.min, left.size + 1, node);
                    } else
                        return null;
                } else {
                    return null;
                }
                // 返回的right != null
            } else if (left == null) {
                if (node.left == null) {
                    if (node.val < right.min) {
                        ans = Math.max(right.size + 1, ans);
                        return new Info(right.max, node.val, right.size + 1, node);
                    } else
                        return null;
                } else
                    return null;
            } else {
                // 返回的left和right都不是空
                if (left.max < node.val && right.min > node.val) {
                    ans = Math.max(left.size + right.size + 1, ans);
                    return new Info(right.max, left.min, left.size + right.size + 1, node);
                }
                else
                    return null;
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[10,5,15,1,8,null,7]");
        System.out.println(solution.largestBSTSubtree(root));
    }
}
