public class 外观数列 {
    static class Solution {
        public String countAndSay(int n) {
            String base = "1";
            if (n == 1) return base;
            base = "11";
            n = n -1;
            //当n>=2时
            while(--n >0){
                StringBuilder result = new StringBuilder("");
                char[] array = base.toCharArray();
                char record = array[0];
                int cl = 0;
                for (int i = 0; i < array.length; i++) {
                    if(record == array[i]){
                        cl ++;
                        continue;
                    }
                    result.append( cl) .append(record);
                    cl = 1;
                    record = array[i];
                }
                result.append( cl) .append(record);
                base = result.toString();
            }
            return base;
        }
    }
}
