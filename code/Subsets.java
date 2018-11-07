import java.util.ArrayList;
import java.util.List;

public class Subsets {

    //注意使用格式化字符串
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            if(nums ==null||nums.length ==0){
                return new ArrayList<>();
            }

            int from = 0;
            int to = (int) (Math.pow(2,nums.length) - 1);

            List<List<Integer>> list = new ArrayList<>();
            for(int i=from;i<=to;i++){

                String format = "%0" + nums.length + "d";
                String binary = String.format(format,Integer.valueOf(Integer.toBinaryString(i)));

                List<Integer> set  = new ArrayList<>();
                for(int j= 0; j < binary.length();j++){
                    if(binary.charAt(j) != '0'&& Integer.valueOf(binary) != 0){
                        set.add(nums[j]);
                    }
                }
                list.add(set);
            }
            return list;
        }
    }
}
