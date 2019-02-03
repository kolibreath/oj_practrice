import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    //this method will be max time exceeded
        class Solution {
            public List<String> letterCasePermutation(String S) {
                if( S == null)
                    return new ArrayList<>();

                if( S.length() == 0){
                    List<String> list = new ArrayList<>();
                    list.add("");
                    return list;
                }
                List<String> list = new ArrayList<>();
                change(list,0,S);

                if(list.size() !=0 )
                    return list;
                else{
                    list.add(S);
                    return list;
                }
            }

            private void change(List<String> list,int index,String str){
                for(int i=index;i<str.length();i++){
                    if(Character.isAlphabetic(str.charAt(i))) {
                        char lowerCase[] = str.toCharArray();
                        lowerCase[i] = Character.toLowerCase(lowerCase[i]);
                        String lower = String.valueOf(lowerCase);
                        if(!list.contains(lower))
                            list.add(lower);

                        change(list,index + 1,lower);

                        char upperCase[] = str.toCharArray();
                        upperCase[i] = Character.toUpperCase(lowerCase[i]);
                        String upper = String.valueOf(upperCase);
                        if(!list.contains(upper))
                            list.add(upper);

                        change(list,index + 1,upper);
                    }
                }
            }
        }
}
