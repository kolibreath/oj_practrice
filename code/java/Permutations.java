import java.util.ArrayList;
import java.util.List;

public class Permutations {
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            if(nums == null || nums.length== 0)
                return new ArrayList<>();
            List<List<Integer>> res  =  new ArrayList<>();
            perMutations(res,0,nums);
            return res;
        }

        public void perMutations(List<List<Integer>> res,int start,int nums[]){
            if(start >= nums.length){
                res.add(converter(nums));
            }
            for(int i = start;i<nums.length;i++){
                swap(nums,i,start);
                perMutations(res,start+1,nums);
                swap(nums,i,start);
            }
        }

        public void swap(int num[],int index1,int index2){
            int temp = num[index1];
            num[index1] = num[index2];
            num[index2] = temp;
        }

        public List<Integer> converter(int nums[]){
            List<Integer> list=  new ArrayList<>();
            for(int n : nums){
                list.add(n);
            }
            return list;
        }
    }
}
