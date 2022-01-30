public class 比较版本号 {
    static class Solution {
        public int compareVersion(String version1, String version2) {
            String[]a = version1.split("\\.");
            String[]b = version2.split("\\.");
            int len1 = a.length, len2 = b.length;
            int i = 0;
            for (;i < len1 && i < len2; i++) {
                // 不能直接转换成数字
                char[] str1 = a[i].toCharArray(), str2 = b[i].toCharArray();
                // 分别找到第一个不等于0的字符
                int index1 = 0;
                while(index1 < str1.length && str1[index1] == '0') index1++;
                int index2 = 0;
                while(index2 < str2.length && str2[index2] == '0') index2++;
                // 比较长度
                if (str1.length - index1 > str2.length - index2) {
                    return 1;
                } else if (str1.length - index1 < str2.length - index2) {
                    return -1;
                }
                // 如果是相等长度 比较字符
                while(index1 != str1.length && index2 != str2.length) {
                    if (str1[index1] > str2[index2])
                        return 1;
                    else if (str1[index1] < str2[index2])
                        return -1;
                    // 相等的情况直接pass
                    index1 ++;
                    index2++;
                }
            }

            // 可能长度不一样
            // 还需要检查每一小段
            if (i < len1) {
                for (int j = i; j < a.length; j++) {
                    if (helper(a[j]) == 1)
                        return 1;
                }
                return 0;
            }
            if (i < len2) {
                for (int j = i; j < b.length; j++) {
                    if (helper(b[j]) == 1)
                        return -1;
                }
                return  0;
            }
            return 0;
        }


        private int helper(String str) {
            char[] chars = str.toCharArray();
            for (char c: chars) {
                if (c != '0')
                    return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String version1 = "1.0.0.1";
        String version2 = "1.0.1";
        System.out.println(solution.compareVersion(version1, version2));
    }
}
