public class ImplementstrSTr {
    class Solution {
        public int strStr(String haystack, String needle) {
            if(haystack.length()< needle.length())
                return -1;
            if(needle.length() == 0)
                return 0;
            int number[] = new int[needle.length()];
            getNext(needle, number);

            int hlen = haystack.length();
            int nlen = needle.length();
            int next[] = new int[needle.length()];
            getNext(needle,next);

            int i = 0, j= 0;
            while(i < hlen && j<nlen){
                if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
                    i ++;j++;
                }else{
                    j = next[j];
                }
            }
            if(j == nlen){
                return i - nlen;
            }else{
                return -1;
            }
        }

        private void getNext(String needle,int next[]){
            int nlen = needle.length();
            int j = -1, i = 0;
            next[i] = -1;
            while(i < nlen -1){
                if(j == -1 || needle.charAt(i) == needle.charAt(j)){
                    j ++ ;i++;
                    next[i] = j;
                }else{
                    j = next[j];
                }
            }
        }
    }
}
