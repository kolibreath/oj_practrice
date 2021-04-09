public class 分割回文串{
   class Solution {
        List<List<String>> result = new LinkedList<>();
        List<String> ans = new LinkedList<>();
        public List<List<String>> partition(String s) {
            dfs(s,0);
            return result;
        }

        public void dfs(String s, int start){
            if (start == s.length()) {
                result.add(new LinkedList<>(ans));
                return;
            }
            for(int j = start ; j< s.length();j++){
                StringBuilder back = new StringBuilder(s.substring(start,j+1));
                if(!back.toString().equals(back.reverse().toString())) continue;
                ans.add(back.toString());
                dfs(s, j+1);
                ans.remove(ans.size() -1);
            }
        }
    }

}