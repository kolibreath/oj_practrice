import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class FindModeInBinaryTree {


   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    class Solution {
       int max;
        public int[] findMode(TreeNode root) {
            if(root == null)
                return new int[0];
            HashMap<Integer,Integer> map = new HashMap<>();
            max = 1;
            traverse(root,map);
            List<Integer> keys = new ArrayList<>();

            for(int key :map.keySet()){
                if(map.get(key) == max){
                    keys.add(key);
                }
            }
            int result[] = new int[keys.size()];
            int counter = 0;
            for(int key:keys){
                result[counter] = key;
                counter++;
            }
            return result;
        }

        public void traverse(TreeNode root, HashMap<Integer,Integer> map){
            if(root == null)
                return;
            if(map.get(root.val)!=null){
                int value = map.get(root.val) + 1;
                if(value > max)
                    max=  value;

                map.put(root.val,value);
            }else{
                map.put(root.val,1);
            }

            traverse(root.left,map);
            traverse(root.right,map);
        }
    }
}
