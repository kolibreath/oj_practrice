import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 三数之和 {
    //双指针问题
    static class Solution {
        private List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> threeSum(int[] num) {
            Arrays.sort(num);
            for(int i = 0;i < num.length;i++){
                if(num[i] > 0 ) break;
                if(i > 0 && num[i] == num[i-1]) continue;

                int l = i+1;
                int r = num.length - 1;
                while(l < r){
                    int sum = num[i] + num[l] + num[r];
                    if(sum == 0){
                        ans.add(Arrays.asList(num[i],num[l], num[r]));
                        while(l < r && num[l] == num[l+1]) l++;
                        while(l < r && num[r] == num[r-1]) r--;
                        l ++;
                        r --;
                    }
                    else if(sum < 0)l ++;
                    else r--;
                }
            }
            return ans;
        }
    }
}
