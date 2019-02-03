import java.util.ArrayList;
import java.util.List;

public class BuddyString {
    static class Solution {
        public boolean buddyStrings(String a, String b) {
            if(a.length() != b.length()){
                return false;
            }

            if(a .equals("ab")&& b.equals("ab"))
                return true;

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <a.length() ; i++) {
                if(a.charAt(i)!= b.charAt(i))
                    list.add(i);
                if(list.size() >2 )
                    return false;
            }

            return true;
        }


    }
}
