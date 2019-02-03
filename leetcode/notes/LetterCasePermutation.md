# Letter case Permutation

[原题地址](https://leetcode.com/problems/letter-case-permutation/description/)
开始的时候使用dfs超时了，后来看了以下别人的做饭感觉可以修正的点有这几个：
原算法
````
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

````
