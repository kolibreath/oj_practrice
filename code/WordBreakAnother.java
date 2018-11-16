import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WordBreakAnother {
    static class Solution {
        boolean flag= false;
        public boolean wordBreak(String s, List<String> wordDict) {

            boolean flag [] = new boolean[s.length() + 1];
            flag[0] = true;
            for(int i = 1 ;i<= s.length() ;i++){
                for(String word:wordDict){
                    if(word.length() <= i)
                        if(flag[i - word.length()])
                            if(s.substring(i - word.length() , i)
                                    .equals(word)){
                                flag[i] = true;
                            }
                    }
                }

                return flag[s.length()];
            }
        }

    }
