import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WordBreak {

    static class Solution {
        boolean flag= false;
        public boolean wordBreak(String s, List<String> wordDict) {
            if(s == null || s.length() == 0)
                return false;
            if(wordDict == null || wordDict.size() == 0)
                return false;

            //需要将输入的顺序按照长短排序
            Collections.sort(wordDict, Comparator.comparingInt(String::length));
            workBreak(s ,0,s.length(),wordDict);

            return flag;
        }

        public void workBreak(String s, int start,int end,List<String> wordDict){
            if(start == end) {
                flag = true;
                return;
            }

            for(int i = 0;i + start<=end;i++){
             // 需要进行一个回溯的匹配！！！
                //通过先进行list 的sort不行如果大量的单词长度相同的无法通过！
                for (int j = 0; j < wordDict.size(); j++) {
                    if( start + i + j > s.length())
                        break;
                    if(wordDict.get(j).equals(s.substring(start,start+i + j))){
                        workBreak(s,start + wordDict.get(j).length() ,end,wordDict);
                    }
                }
            }
        }
    }
}
