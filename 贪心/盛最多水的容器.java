import java.util.Random;

public class 盛最多水的容器 {
    static class Solution {
        public static int maxArea(int[] height) {
            if(height == null || height.length == 0) return 0;
            int start = 0;
            int end = height.length - 1;
            int max = 0;
            while(start < end) {
                max = Math.max(Math.min(height[start], height[end]) * (end - start), max);
                if(height[start] < height[end]) start ++;
                else end --;
            }
            return max;
        }

        public static int maxArea1(int[] height) {
            int max = 0;
            for(int i =0; i < height.length ;i ++) {
                for (int j = height.length -1 ; j > i; j--) {
                    max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
                }
            }
            return max;
        }

        public static void main(String[] args) {
            int length = 4;
            Random random = new Random();
            int heights[] = new int[length];
            for(int i = 0; i< length ;i ++) heights[i] = (int)(Math.floor(random.nextDouble() * 100));
            System.out.println("dont know: " + maxArea(heights) + " true:" + maxArea1(heights));
        }
    }



}
