public class 重复叠加字符串匹配 {
        static class Solution {
            public int repeatedStringMatch(String repeat, String sub) {
                // 记录字符出现的次数
                int[]a = new int[26];
                int[]b = new int[26];

                char[] repeatArr = repeat.toCharArray();
                char[] subArr = sub.toCharArray();

                for(char c: repeatArr) a[c-'a']++;
                for(char c: subArr) b[c-'a']++;

                // 计算至少需要几个repeat可以构成所有的sub中的字符？
                int counter = 1;
                while(true) {
                    int k = 0;
                    for(; k < sub.length(); k ++) {
                        int i = subArr[k] - 'a';
                        if(b[i] != 0 && a[i] == 0) return -1;
                        // repeat字符串中包含sub中的字符
                        // 如果小于等于0 说明当前的repeat可以组成sub
                        // 大于0 说明重复次数不够多
                        if(b[i] - (a[i] * counter) > 0) break;
                    }
                    if (k == sub.length()) break;
                    counter ++;
                }
                // counter 是最小的重复次数
                counter ++;
                StringBuilder builder = new StringBuilder();
                for(int i =0; i < counter; i++ ) builder.append(repeat);
                String repeated = builder.toString();
                // 进行查找
                for (int i = 0; i < repeated.length() - sub.length() + 1; i++) {
                    int j = 0;
                    for(; j < sub.length(); j ++ ) {
                        if(repeated.charAt(i + j) != sub.charAt(j)) break;
                    }
                    if (j == sub.length()) {
                        // 已经走到了复制若干遍的结尾
                        if ((repeated.length() - (i + j)) / repeat.length() >= 1)
                            return counter -1;
                        else return counter;
                    }
                }
                return -1;
            }
        }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String repeat = "a";
        String sub = "aa";
        System.out.println(solution.repeatedStringMatch(repeat, sub));
    }
}
