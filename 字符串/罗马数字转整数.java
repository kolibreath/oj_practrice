import java.util.HashMap;
import java.util.Map;

public class 罗马数字转整数 {
   static class Solution {
        public int romanToInt(String s) {
//            I可以放在V(5)   和X(10) 的左边，来表示 4 和 9。
//            X可以放在L(50)  和C(100) 的左边，来表示 40 和90。
//            C可以放在D(500) 和M(1000) 的左边，来表示400和900
            char[] chars = s.toCharArray();
            int sum = 0, n = chars.length;
            for (int i = 0; i < chars.length;) {
                // 判断下一个
                if (chars[i] == 'I') {
                    if (i + 1 < n && chars[i+1] == 'V') {
                        sum += 4;
                        i += 2;
                    } else if (i + 1 < n && chars[i+1] == 'X') {
                        sum += 9;
                        i += 2;
                    } else {
                        sum += 1;
                        i++;
                    }
                } else if (chars[i] == 'X') {
                    if (i + 1 < n && chars[i+1] == 'L') {
                        sum += 40;
                        i += 2;
                    } else if (i + 1 < n && chars[i+1] == 'C') {
                        sum += 90;
                        i += 2;
                    } else {
                        sum += 10;
                        i++;
                    }
                } else if (chars[i] == 'C') {
                    if (i + 1 < n && chars[i+1] == 'D') {
                        sum += 400;
                        i += 2;
                    } else if (i + 1 < n && chars[i+1] == 'M') {
                        sum += 900;
                        i += 2;
                    } else {
                        sum += 100;
                        i++;
                    }
                } else {
                    if (chars[i] == 'V')
                        sum += 5;
                    else if (chars[i] == 'L')
                        sum += 50;
                    else if (chars[i] == 'D')
                        sum += 500;
                    else if (chars[i] == 'M')
                        sum += 1000;
                    i ++;
                }
            }
            return sum;
        }

        public int romanToInt2(String s) {
            Map<Character, Integer> map = new HashMap<Character, Integer>(){{
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }};
            int sum = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int value = map.get(chars[i]);
                if (i + 1 < chars.length && value < map.get(chars[i+1]))
                    sum -= value;
                else
                    sum += value;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "MCMXCIV";
        System.out.println(solution.romanToInt(s));
    }
}
