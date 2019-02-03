public class MergeTwoBinaryTrees {

   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

   //这种题目很操蛋 java 不能改变参数的数值 怎么做？
    //需要返数值
    class Solution {
       TreeNode merged = null;
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            merged =  constructMergeTrees(t1,t2,merged);

            return merged;
        }

        public TreeNode constructMergeTrees(TreeNode q,TreeNode p,TreeNode merged){
            if(q==null && p == null){
                return merged;
            }else if(q == null && p !=null){

                merged = new TreeNode(p.val);
                //这个点的之后的字节点也是空的，变成一个子树和空树进行合并
                constructMergeTrees(null,p.left,merged.left);
                constructMergeTrees(null,p.right,merged.right);

            }else if(q != null && p ==null){
                merged = new TreeNode(q.val);
                //这个点的之后的字节点也是空的，变成一个子树和空树进行合并
                constructMergeTrees(q.left,null,merged.left);
                constructMergeTrees(q.right,null,merged.right);

            }else if(q == null && p !=null){
                merged = new TreeNode(p.val);
                //这个点的之后的字节点也是空的，变成一个子树和空树进行合并
                constructMergeTrees(null,p.left,merged.left);
                constructMergeTrees(null,p.right,merged.right);
            }else{
                merged = new TreeNode(p.val + q.val);
                constructMergeTrees(q.left,p.left,merged.left);
                constructMergeTrees(q.right,p.right,merged.right);
            }

            return null;
        }
    }
}
