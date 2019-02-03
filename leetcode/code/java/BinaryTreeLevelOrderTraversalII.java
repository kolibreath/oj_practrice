import java.util.*;

public class BinaryTreeLevelOrderTraversalII {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
        class Solution {
            public List<List<Integer>> levelOrderBottom(TreeNode root) {

                if(root ==null)
                    return new ArrayList<>();

                List<List<Integer>> result = new ArrayList<>();
                Queue<TreeNode> queue = new LinkedList<>();

                queue.add(root);

                while(!queue.isEmpty()){

                    List<Integer> temp = new ArrayList<>();
                    int size = queue.size();
                    for(int i=0;i<size;i++){
                     TreeNode node  = queue.poll();
                     temp.add(node.val);

                     if(node.left!=null)
                         queue.add(node.left);
                     if(node.right!=null)
                         queue.add(node.right);

                    }

                    if(!temp.isEmpty())
                        result.add(temp);
                }
                Collections.reverse(result);

                return result;
                }
            }

    }
