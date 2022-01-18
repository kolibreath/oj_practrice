import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 从英文中重建数字 {
    static class Solution {
        public String originalDigits(String s) {
            String[]numbers = new String[] {
                    "zero", "one", "two", "three", "four", "five", "six", "seven",
                    "eight", "nine"
            };
            // 构建数字hash
            // 常数耗时
            int[][] nhash = new int[10][26];
            int k = 0;
            for (String ns : numbers) {
                char[]array = ns.toCharArray();
                for(char c : array) {
                    nhash[k][c-'a'] ++;
                }
                k ++;
            }

            // 构建字符串hash
            int[] hash = new int[26];
            char[] chars = s.toCharArray();
            for(char c : chars) hash[c-'a'] ++;


            // 移除字符
            ArrayList<Integer> list = new ArrayList<>();
            int count = s.length();
            while(count > 0) {
                // 使用字符串减去尝试的数字
                for (int i = 0; i < 10; i++) {
                    // 尝试数字i
                    boolean flag = true;
                    for (int j = 0; j < 26; j++) {
                        if (hash[j] < nhash[i][j]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        list.add(i);
                        for (int j = 0; j < 26 ; j++) {
                            if (hash[j] != 0) {
                                hash[j] = hash[j] - nhash[i][j];
                                count = count - nhash[i][j];
                            }
                        }
                    }
                }
            }

            // 输出结果
            StringBuffer buffer = new StringBuffer();
            Collections.sort(list);
            for(int i : list)
                buffer.append(i);
            return buffer.toString();
        }
    }

    static class Solution2 {
        public String originalDigits(String s) {
            Map<Character, Integer> c = new HashMap<Character, Integer>();
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                c.put(ch, c.getOrDefault(ch, 0) + 1);
            }

            int[] cnt = new int[10];
            cnt[0] = c.getOrDefault('z', 0);
            cnt[2] = c.getOrDefault('w', 0);
            cnt[4] = c.getOrDefault('u', 0);
            cnt[6] = c.getOrDefault('x', 0);
            cnt[8] = c.getOrDefault('g', 0);

            cnt[3] = c.getOrDefault('h', 0) - cnt[8];
            cnt[5] = c.getOrDefault('f', 0) - cnt[4];
            cnt[7] = c.getOrDefault('s', 0) - cnt[6];

            cnt[1] = c.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

            cnt[9] = c.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

            StringBuffer ans = new StringBuffer();
            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < cnt[i]; ++j) {
                    ans.append((char) (i + '0'));
                }
            }
            return ans.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s =  "fviefuro";
        System.out.println(solution.originalDigits(s));
    }
}
