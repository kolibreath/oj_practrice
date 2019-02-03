import java.util.*;

public class Permutationsii {
   static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            if(nums.length == 0 || nums == null) return new ArrayList<>();
            Arrays.sort(nums);

            Set<List<Integer>> list = new HashSet<>();

            permutations(list,0,nums);

            List<List<Integer>> l = new ArrayList<>(list);
            return l;
        }

        public void permutations(Set<List<Integer>> list, int start,int nums[]){
            if(start >= nums.length) {
                list.add(converter(nums));
                return;
            }
            for(int i = start;i<nums.length;i++){
                swap(nums,i,start);
                permutations(list,start+1,nums);
                swap(nums,i,start);
            }
        }

        public List<Integer> converter(int nums[]){
            List<Integer> list= new ArrayList<>();
            for(int i : nums)
                list.add(i);
            return list;
        }

        public void swap(int nums[],int index1,int index2 ){
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
   }
}
