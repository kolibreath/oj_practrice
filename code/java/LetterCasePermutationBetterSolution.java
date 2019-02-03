import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutationBetterSolution {


    class Solution {
        List<String> all;
        public List<String> letterCasePermutation(String S) {
            all = new ArrayList<>();
            backtrack(S.toCharArray(), 0, "");
            return all;
        }

        private void backtrack(char[] ar,int index,String str){
            if(index == ar.length){
                all.add(str);
            }else{

                if(Character.isAlphabetic(ar[index])){
                    char ch = ar[index];
                    backtrack(ar,index +1 ,str + ch);
                    if(ch <= 'z' && ch >= 'a') {
                        ch = (char) (ch - 'a'  + 'A');
                    }else if(ch <= 'Z' && ch >= 'A'){
                        ch = (char) (ch - 'A' + 'a');
                    }
                    backtrack(ar,index + 1, str + ch);
                }else{
                    backtrack(ar,index +1 ,str+ar[index]);
                }
            }
        }
    }
}
