import java.util.LinkedList;

public class 路径总和III {
    static class Solution {
//        private LinkedList<LinkedList<Integer>> paths = new LinkedList<>();
//        private int ans = 0;
//        private void dfs(TreeNode node, LinkedList<Integer> cur){
//            if(node == null) return;
//            cur.add(node.val);
//            if(node.left == null && node.right == null) paths.add(new LinkedList<>(cur));
//            dfs(node.left, cur);
//            dfs(node.right,cur);
//            cur.removeLast();
//        }
//        private void traverse(LinkedList<LinkedList<Integer>>  list , int sum){
//            for(int i = 0; i< list.size();i++){
//                for (int j = 0; j < list.get(i).size() ; j++) {
//                    int cur = 0;
//                    for (int k = j; k < list.get(i).size() ; k++) {
//                        cur += list.get(i).get(k);
//                        if( cur == sum) {
//                            ans ++;
//                            cur  = 0;
//                        }
//                    }
//                }
//            }
//        }
//        public int pathSum(TreeNode root, int sum) {
//            dfs(root,new LinkedList<>());
//            traverse(paths, sum);
//            return ans;
//        }
        public int dfs(TreeNode node, int [] array, int p, int sum){
            if(node == null) return 0;
            int n = 0, cur = 0;
            array[p] = node.val;
            for (int i = p; i >=0 ; i--) {
                cur += array[i];
                if(cur == sum) {
                 n++;
                }
            }
            int left = dfs(node.left , array, p + 1, sum);
            int right= dfs(node.right, array, p + 1, sum);
            return n+left + right;
        }
        public int pathSum(TreeNode root, int sum){
            return dfs(root, new int[1000], 0, sum);
        }
    }
}
