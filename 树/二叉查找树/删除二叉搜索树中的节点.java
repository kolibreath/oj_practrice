public class 删除二叉搜索树中的节点 {
    static class Solution {
        private int forward(TreeNode node){
            node = node.left;
            while(node.right!= null) node = node.right;
            return node.val;
        }

        private int backward(TreeNode node){
            node = node.right;
            while(node.left != null) node = node.left;
            return node.val;
        }

        public TreeNode deleteNode(TreeNode node, int key) {
            //需要
            //为什么需要： 是中序遍历的出口
            if(node == null) return null;
            if(key > node.val) node.right = deleteNode(node.right, key);
            else if(key < node.val) node.left = deleteNode(node.left, key);
            else{
                if(node.left == null && node.right == null) node = null;
                else if(node.right == null){
                    node.val = forward(node);
                    node.left = deleteNode(node.left, node.val);
                }else{
                    node.val = backward(node);
                    node.right = deleteNode(node.right, node.val);
                }
            }
            return node;
        }
    }
}