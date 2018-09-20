import java.util.Scanner;

public class LengthOfLastWord {
    static class Solution {
        public int lengthOfLastWord(String s) {
            if(s == null || s.length() == 0 )
                return 0;
            int length = 0;
            Scanner scanner = new Scanner(s);
            while (scanner.hasNext())
                length = scanner.next().length();

            return length;
        }
    }
}
