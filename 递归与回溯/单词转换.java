public class 单词转换 {
    class Solution {
        List<String> result = new ArrayList<>();
        List<String> histroy = new ArrayList<>();
        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            result.add(beginWord);
            boolean b = dfs(beginWord,endWord,wordList);
            if (b) return result;
            return new ArrayList<>();
        }

        private boolean dfs(String beginWord,String endWord,List<String> wordList){
            if (beginWord.equals(endWord)) return true;
            if (histroy.contains(beginWord)) return false;
            // 可直接将无法达到的直接排除
            for(String target: wordList){
                if (!near(beginWord,target) || result.contains(target)) continue;
                result.add(target);
                if(dfs(target,endWord,wordList)) return true;
                histroy.add(beginWord);
                result.remove(result.size()-1);
            }
            return false;
        }

        // 如果不为1 说明不能通过一次替换达到
        private boolean near(String cur,String target){
            int diff = 0;
            for(int i = 0; i < cur.length();i++){
                if (cur.charAt(i) != target.charAt(i)) diff++;
            }
            return diff == 1;
        }
    }
}