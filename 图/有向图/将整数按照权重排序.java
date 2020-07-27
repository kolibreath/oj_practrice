import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class 将整数按照权重排序 {
    static class Solution {
        private HashMap<Integer, Integer> map = new HashMap<>();
        private int dfs(int number){
            if(map.keySet().contains(number)) return map.get(number);
            if(number == 1) {
                map.put(number,1);
                return 1;
            }
            if((number & 1 ) != 0){
                int value = dfs(number * 3 + 1) + 1;
                map.putIfAbsent(number, value);
                return value;
            }else{
                int value = dfs(number / 2) + 1;
                map.putIfAbsent(number,value);
                return value;
            }
        }
        public int getKth(int lo, int hi, int k) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = lo; i <= hi ;i++){
                list.add(i);
                dfs(i);
            }

            Collections.sort(list, (o1, o2) -> {
                if(!map.get(o1).equals(map.get(o2))){
                    return map.get(o1) - map.get(o2);
                }else{
                    return o1 - o2;
                }
            });
            return list.get(k-1);
        }
    }
}