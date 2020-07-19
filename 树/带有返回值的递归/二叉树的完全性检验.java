import java.util.*;

public class 二叉树的完全性检验 {
     static  class Solution {
         public boolean isCompleteTree(TreeNode root) {
             Queue<TreeNode> queue = new LinkedList<>();
             queue.add(root);
             while(!queue.isEmpty()){
                 boolean flag = false;
                 int size = queue.size();
                 for (int i = 0; i < size ; i++) {
                     TreeNode temp = queue.poll();
                     if(temp != null){
                         if(flag) return false;
                         queue.add(temp.left);
                         queue.add(temp.right);
                     }else
                         flag = true;
                 }
             }
             return true;
         }
     }
}
