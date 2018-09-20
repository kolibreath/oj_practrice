import java.util.Arrays;

public class Heaters {

   static class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int i = 0, result = 0;
            for (int house: houses){
                while(i + 1 < heaters.length && Math.abs(house - heaters[i])<= Math.abs(house - heaters[i + 1])){
                    i++;
                }
                result = Math.abs(house - heaters[i]);
            }
            return result;
        }
    }
}
