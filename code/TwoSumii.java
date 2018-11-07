public class TwoSumii {
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            if(numbers.length ==0 || numbers ==null){
                return new int[0];
            }

            int low = 0, high = numbers.length -1;
            while(low<high){
                if(numbers[low]+ numbers[high] == target)
                    break;
                else if(numbers[low] + numbers[high] > target)
                    high --;
                else{
                    low ++;
                }
            }
            return new int[]{++low , ++high};
        }
    }
}
