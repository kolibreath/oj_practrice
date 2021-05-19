public class 不同的二叉搜索树 {
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new ArrayList<TreeNode>();
            return dfs(1, n);
        }

        private List<TreeNode> dfs(int start, int end){

            List<TreeNode> nodes = new LinkedList<>();
            if (start > end){
                nodes.add(null);
                return nodes;
            }
            for (int i = start; i <= end; i++){
                // 生成左子树的集合
                List<TreeNode> leftNodes  = dfs(start, i-1);
                // 生成右子树的集合
                List<TreeNode> rightNodes = dfs( i+1, end);
                
                for (TreeNode left : leftNodes){
                    for (TreeNode right : rightNodes){
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        nodes.add(root);
                    }
                }
            }
            return nodes;
        }
    }
}