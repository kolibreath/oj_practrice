import java.util.Arrays;

public class 加一 {
    static class Solution {
        public int[] plusOne(int[] digits) {
           int carry = 1;
           reverse(digits);
            for (int i = 0; i < digits.length; i++) {
                int temp = digits[i] + carry;
                carry = temp / 10;
                digits[i] = temp % 10;
            }
            if(carry == 1){
                int result[] = new int[digits.length +1];
                result[result.length - 1] = carry;
                reverse(result);
                return result;
            }
            reverse(digits);
            return digits;
        }

        private void reverse(int[] digits){
            int start = 0, end = digits.length - 1;
            while(start < end){
                int temp = digits[start];
                digits[start] = digits[end];
                digits[end] = temp;
                start ++;
                end --;
            }
        }
    }
}
