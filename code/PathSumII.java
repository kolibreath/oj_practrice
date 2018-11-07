import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumII {

        public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        static class Solution{
            public void pathSumHelper(TreeNode root,int sum,List<Integer> sumList,
                                      List<List<Integer>> pathlist){
                if(root == null){
                    return;
                }

                sumList.add(root.val);
                sum = sum-root.val;
                if(root.left == null && root.right ==null){
                    if(sum == 0)
                        pathlist.add(new ArrayList<Integer>(sumList));
                    else{
                        if(root.left!=null)
                            pathSumHelper(root.left,sum,sumList,pathlist);
                        if(root.right!=null)
                            pathSumHelper(root.right,sum,sumList,pathlist);
                    }
                }
                sumList.remove(sumList.size() - 1);
            }

            public List<List<Integer>> pathSum(TreeNode root, int sum){
                List<List<Integer>> pathlist = new ArrayList<>();
                List<Integer> sumlist  = new ArrayList<>();

                pathSumHelper(root,sum,sumlist,pathlist);
                return pathlist;
            }
        }

}
