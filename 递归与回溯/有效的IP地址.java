import java.util.ArrayList;
import java.util.List;

public class 有效的IP地址 {
   static class Solution {
        public List<String> restoreIpAddresses(String s) {
            dfs(0, s, new ArrayList<>());
            return ans;
        }

        private ArrayList<String> ans = new ArrayList<>();
        private void dfs(int level, String s, ArrayList<String> path) {
            if (level == 4) {
                StringBuffer builder = new StringBuffer();
                for (int i = 0; i < path.size(); i++) {
                    builder.append(path.get(i));
                    if (i != path.size() - 1) builder.append(".");
                }
                ans.add(builder.toString());
                return;
            }

            for (int i = 1; i <= 3  && i <= s.length(); i++) {
                String temp = s.substring(0, i);
                // 以0开头并且长度大于1 也不行
                if (temp.charAt(0) == '0' && temp.length() > 1) continue;
                // 只有当i==3时 才需要检验这个String是否合法
                if (i == 3) {
                    int it = Integer.parseInt(temp);
                    if (it > 255) continue;
                }
                // 剩下的长度不能超过均分长度
                String rest = s.substring(i);
                int num = 3 - level;
                int max = num * 3;
                if (rest.length() > max) continue;
                path.add(temp);
                dfs(level + 1, rest, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
       Solution solution = new Solution();
       String s = "101023";
       List<String> list=  solution.restoreIpAddresses(s);
       for(String i : list) System.out.println(i);
    }
}
