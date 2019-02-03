import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinatonSum {
       static   class Solution {
            public List<List<Integer>> combinationSum(int[] candidates, int target) {
                if(candidates == null || candidates.length == 0)
                    return new ArrayList<>();
                List<List<Integer>> list=  new ArrayList<>();
                List<Integer> tempList  = new ArrayList<>();
                Arrays.sort(candidates);
                getCombination(list,tempList,candidates,target,0);
                return list;
            }

            public void getCombination(List<List<Integer>> list, List<Integer> tempList,
                                       int[] c,int remain,int start){
                if(remain < 0)
                    return;
                else  if(remain == 0)
                    list.add(new ArrayList<>(tempList));
                else {
                    for (int i = start; i < c.length; i++) {
                        if( i > start && c[i] == c[i-1])
                            continue;
                        tempList.add(c[i]);
                        getCombination(list, tempList, c, remain - c[i], i+1);
                        tempList.remove(tempList.size() - 1);
                    }
                }
            }
        }
}
