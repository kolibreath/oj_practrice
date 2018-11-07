import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    class Solution {
        public  boolean wordPattern(String pattern, String str) {
            String[] words = str.split(" ");  //分割开str这个字符串
            if (words.length != pattern.length())  //如果长度不同，明显不符合题意，返回false
                return false;
            Map index = new HashMap();  //用map的解释见下边的分析
            for (Integer i = 0; i < words.length; ++i)
                if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                    return false;
            return true;
        }

    }
}
