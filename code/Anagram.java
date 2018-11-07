import java.util.ArrayList;
import java.util.List;

public class Anagram {
   static class Solution {
        public boolean isAnagram(String s, String t) {
            if(s == null || t == null)
                return false;
            if(s.length() != t.length())
                return false;

            List<Character> slist = new ArrayList<>();

            for(int i =0;i<s.length();i++){
                slist.add(s.charAt(i));
            }
            for(int i=0;i<t.length();i++){
                for(int j= 0;j<slist.size();j++){
                    if(slist.get(j) == t.charAt(i)){
                        slist.remove(j);
                        break;
                    }
                    if(j == slist.size() -1){
                        return false;
                    }
                }
            }
            return  true;
        }
    }
}
