import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SameTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q == null)
                return true;
            if(p == null || q == null)
                return false;

            List<Integer> pList = new ArrayList<>();
            List<Integer> qList = new ArrayList<>();

            pList.add(p.val);
            qList.add(q.val);

            isSame(p,pList);
            isSame(q,qList);

            for(int i= 0;i<pList.size()&&i<qList.size();i++){
                if(pList.get(i) == null && qList.get(i) != null)
                    return false;

                if(pList.get(i) != null && qList.get(i) == null)
                    return false;

                if(pList.get(i) == null && qList.get(i) == null)
                    continue;

                if(!pList.get(i).equals(qList.get(i)))
                    return false;
            }

            return true;
        }

        public void isSame(TreeNode root, List<Integer> list){

            //如果是字节点返回
            if(root.left == null && root.right == null)
                return;

            if(root.left == null)
                list.add(null);
            else{
                list.add(root.left.val);
                isSame(root.left,list);
            }


            if(root.right == null)
                list.add(null);
            else{
                list.add(root.right.val);
                isSame(root.right,list);
            }
        }
    }
}
