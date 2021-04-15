public class 电话号码的字母组合 {
     class Solution {
        List<String> result = new LinkedList<>();
        HashMap<Integer, String> map = new HashMap<>();
        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) return result;
            map.put(2,"abc"); map.put(3,"def"); map.put(4,"ghi"); map.put(5,"jkl");
            map.put(6,"mno"); map.put(7,"pqrs"); map.put(8,"tuv");map.put(9,"wxyz");
            dfs(digits,0,"");
            return result;
        }

        // index 表示字符串数字的下标
        private void dfs(String digits,int index,String cur){
            if (index == digits.length()) {
                result.add(cur);return;
            }
            int d = digits.charAt(index) - '0';
            String number = map.get(d);
            for (int j = 0; j < number.length(); j ++) {
                String temp = cur;
                temp += number.charAt(j);
                dfs(digits, index+1,temp);
            }

        }
    }
}