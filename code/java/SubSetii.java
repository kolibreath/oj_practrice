import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SubSetii {

    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {

            int length = nums.length;
            String format = "%0"+ length + "d";
            List<List<Integer>> result = new LinkedList<>();

            int size = (int) Math.pow(2,length);
            for(int i=0;i<size;i++){
                String  num = String.format(format,Integer.parseInt(Integer.toBinaryString(i)));

                List<Integer> temp = new LinkedList<>();
                for(int j = 0;j<num.length();j++){
                    if(num.charAt(j) == '1'){
                        temp.add(nums[j]);
                    }
                }
                Collections.sort(temp);
                if(result.contains(temp))
                    continue;
                result.add(temp);
            }

            return result;
        }
    }
}
